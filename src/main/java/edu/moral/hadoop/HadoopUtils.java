package edu.moral.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created with default template
 *
 * @author : MoralIntegrity
 * @date : 2018-11-12 20:59
 * description : util edu.moral.hadoop class HadoopUtils
 */
public class HadoopUtils {

    public static void main(String...args) throws Exception{

        Configuration configuration = new Configuration();

        configuration.set("fs.defaultFS", "hdfs://192.168.120.136:9000");
        configuration.set("dfs.replication", "1");

        FileSystem fileSystem = FileSystem.get(configuration);

        fileSystem.delete(new Path("/hadoop/ttt.txt"), true);

        FSDataOutputStream out = fileSystem.create(new Path("/hadoop/ttt1.txt"));

        FileInputStream in = new FileInputStream(new File("d:/tmp/repository.txt"));

        IOUtils.copyBytes(in, out, 4096, true);
    }
}
