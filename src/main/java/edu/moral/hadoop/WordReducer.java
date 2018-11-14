package edu.moral.hadoop;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.stream.StreamSupport;

/**
 * Created with default template
 *
 * @author : MoralIntegrity
 * @date : 2018-11-14 10:21
 * description : util edu.moral.hadoop class WordReducer
 */
public class WordReducer extends Reducer<Text, LongWritable, Text, LongWritable> {

    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        context.write(key, StreamSupport.stream(values.spliterator(), false).reduce((x, y) -> new LongWritable(x.get() + y.get())).get());
    }
}
