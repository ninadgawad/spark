import org.drools.core.ClassObjectFilter;
import org.drools.core.impl.KnowledgeBaseImpl;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.List;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

public class SparkDrools {

    public static void main(String[] args) {

        // Initialize the Spark context
        JavaSparkContext sc = new JavaSparkContext("local[2]", "Drools Spark Example");

        // Load the data into a Spark RDD
        List<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(2);
        data.add(3);
        JavaRDD<Integer> rdd = sc.parallelize(data);

        // Initialize the Drools KieBase
        KieServices ks = KieServices.Factory.get();
        KieFileSystem kfs = ks.newKieFileSystem();
        kfs.write("src/main/resources/rules.drl", "package drools.spark.example\n\nrule \"Hello World\"\n\twhen\n\t\t$i : Integer(intValue > 1)\n\tthen\n\t\tSystem.out.println(\"Hello World: \" + $i);\nend");
        KieBuilder kieBuilder = ks.newKieBuilder(kfs).buildAll();
        KieModule kieModule = kieBuilder.getKieModule();
        KieContainer kieContainer = ks.newKieContainer(kieModule.getReleaseId());
        KieBase kieBase = kieContainer.getKieBase();

        // Apply the Drools rules to the RDD
        JavaRDD<Integer> result = rdd.map(new Function<Integer, Integer>() {
            public Integer call(Integer i) {
                KieSession kieSession = kieBase.newKieSession();
                kieSession.insert(i);
                kieSession.fireAllRules();
                kieSession.dispose();
                return i;
            }
        });

        // Collect the results and print them
        List<Integer> output = result.collect();
        for (Integer i : output) {
            System.out.println(i);
        }

        // Stop the Spark context
        sc.stop();
    }
}
