/*
* MIT License
* 
* Copyright (c) 2021 Dalton Lins
* 
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
* 
* The above copyright notice and this permission notice shall be included in all
* copies or substantial portions of the Software.
* 
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
* SOFTWARE.
*/
package org.github.jdaltonlins.peoo.ui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author Dalton
 */
public class Backable extends JFrame {

    private JFrame backFrame;

    public Backable(JFrame backFrame) {
        this.backFrame = backFrame;
        if (backFrame != null) {
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    backFrame.setVisible(true);
                }
            });
        }
        try {
            this.setIconImage(ImageIO.read(getClass().getResource("/assets/mini-logo.png")));
        } catch (IOException ex) {
            Logger.getLogger(Backable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void active() {
        if (backFrame != null) {
            this.backFrame.setVisible(false);
        }
        this.setVisible(true);
    }

    @Override
    public void dispose() {
        if (backFrame != null) {
            backFrame.setVisible(true);
        }
        super.dispose(); //To change body of generated methods, choose Tools | Templates.
    }
}
