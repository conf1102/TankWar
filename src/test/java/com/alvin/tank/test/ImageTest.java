package com.alvin.tank.test;

import com.alvin.tank.TankFrame;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class ImageTest {
    @Test
    public void test() {
        BufferedImage image = null;
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("images/tankD.gif");
            image = ImageIO.read(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertNotNull(image);
    }

}
