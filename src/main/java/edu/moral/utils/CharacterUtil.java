package edu.moral.utils;

import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created with default template
 * Author: MoralIntegrity
 * Date: 2018-04-20
 * Time: 11:36
 * Description:
 */
public class CharacterUtil {

    public static void main(String...args) throws Exception{


        String content = "富春山居图";

        //firstCharacter(content);

        List<String> temp = new ArrayList<>();

        temp.add("s");
        temp.add("s");
        temp.add("s");
        temp.add("d");
        temp.add("s");
        temp.add("s");
        temp.add("s");

        System.out.println(temp.stream().filter(i -> Objects.equals(i,  "d")).collect(Collectors.toList()));


    }

    public static void firstCharacter(String content) throws Exception{
        System.out.println(((Character)PinyinHelper.getShortPinyin(content).charAt(0)).toString().toUpperCase());


        System.out.println(PinyinHelper.convertToPinyinString(content,"", PinyinFormat.WITHOUT_TONE));

        System.out.println("201801301410037".substring("201801301410037".length() - 4));
    }
}

