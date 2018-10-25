package edu.moral.utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Objects;

/**
 * Created with default template
 * Author: MoralIntegrity
 * Date: 2018-06-15
 * Time: 17:25
 * Description:
 */
public class KeyboardUtil {

    public static void main(String...args) throws Exception{

        Robot robot = new Robot();
        final String musicTonghua = "      LONOL LONOL LONO OOMML LONOL LQPPO LONOM MMOTS PPRRQQ QQNPOONO ONOR LSRQP PPRRQQ QQVUTUV VPOT TTSSS LSRQ QRQ QRQRQPOOQST TTSPPRQ OQST TTSPPRQRQPO PQMMOONO";
        final String hls = "   J J K L L K J I H H I J J I IJ J K L L K J I H H I J I H H I I J H I J K J H I J K J I H I E J J K L L K J I H H I J I H H";
        final String qqqg = "  HHIJ LMONNNLJ IIIJK MOQPPNLHHIJ LMONNNLJ IIIJK MOQPPNLMLMLMNNMN PPPPNOPQQQPPPOQ NLMLMOPQQPQ QPOP OMM LMOP QQPQ QSTSQQQQPPOPOM QQRQPOP QQ Q PPOP OMOO";

        for(Character temp : hls.toCharArray()){
            int value = Integer.valueOf(temp);

            if(Objects.equals(value, 32)){
                Thread.sleep(300);
            } else {
                robot.keyPress(value);
                robot.keyRelease(value);

                Thread.sleep(200);
            }
        }
    }
}
