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
package org.github.jdaltonlins.peoo;

import com.github.weisj.darklaf.LafManager;
import com.github.weisj.darklaf.theme.IntelliJTheme;
import org.github.jdaltonlins.peoo.ui.JMenu;
import org.github.jdaltonlins.peoo.ui.JSplashScreen;
import org.github.jdaltonlins.peoo.utils.Manager;

/**
 *
 * @author Dalton
 */
public class Inicio {

    public static void main(String[] args) {
        System.out.println("[App] Inicializando Gerencia da Cabeleileira Leila");
        
        Manager.loadToCache();
        
        
        System.out.println("[App] Carregando tema...");
        LafManager.setTheme(JMenu.THEMES[Manager.getSelectedTheme()]);
        System.out.println("[App] Instalando tema...");
        LafManager.install();
        
        System.out.println("[UI] Inicializando a interface grafica...");
        new JSplashScreen();
        System.out.println("[UI] Exibindo menu...");
        new JMenu();
    }

}
