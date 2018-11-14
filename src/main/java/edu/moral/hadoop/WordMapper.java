package edu.moral.hadoop;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created with default template
 *
 * @author : MoralIntegrity
 * @date : 2018-11-14 10:20
 * description : util edu.moral.hadoop class WordMapper
 */
public class WordMapper extends Mapper<LongWritable, Text, Text, LongWritable> {

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