package edu.moral.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.log4j.BasicConfigurator;

/**
 * Created with default template
 *
 * @author : MoralIntegrity
 * @date : 2018-11-13 11:21
 * description : util edu.moral.hadoop class MapReduce
 */
public class MapReduce {


    public static void main(String...args) throws Exception{
        Configuration configuration = new Configuration();

        Job job = Job.getInstance(configuration);

        job.setMapperClass(WordMapper.class);
        job.setReducerClass(WordReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        FileInputFormat.setInputPaths(job, "d:/tmp/log/customer.log");
        FileOutputFormat.setOutputPath(job, new Path("d:/tmp/hadoop/customerLog"));

        job.waitForCompletion(true);

    }
}
