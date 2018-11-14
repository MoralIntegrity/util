package edu.moral.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.util.stream.StreamSupport;

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

        FileInputFormat.setInputPaths(job, "d:/tmp/log/auth.log");
        FileOutputFormat.setOutputPath(job, new Path("d:/tmp/hadoop/logout"));

        job.waitForCompletion(true);

    }

    class WordMapper extends Mapper<LongWritable, Text, Text, LongWritable> {

        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {


            final LongWritable single = new LongWritable(1);

            String current = value.toString();

            String[] words = current.split(" ");

            for(String entity : words){
                context.write(new Text(entity), single);
            }
        }
    }

    class WordReducer extends Reducer<Text, LongWritable, Text, LongWritable> {

        @Override
        protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
            context.write(key, StreamSupport.stream(values.spliterator(), false).reduce((x, y) -> new LongWritable(x.get() + y.get())).get());
        }
    }
}
