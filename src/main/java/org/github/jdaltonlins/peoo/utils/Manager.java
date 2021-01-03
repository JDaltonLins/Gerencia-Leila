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
package org.github.jdaltonlins.peoo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.github.jdaltonlins.peoo.obj.Cliente;
import org.github.jdaltonlins.peoo.obj.Quadruple;
import org.github.jdaltonlins.peoo.obj.Servico;

/**
 *
 * @author Dalton
 */
public class Manager {
    
    private static final int DEFAULT_THEME = 1;
    
    private static int nextClientId = 1;
    private static int theme = 0;

    private static final File FILE = new File("./dados.bin");
    private static Map<Integer, Cliente> clientes;
    private static List<Servico> servicos;

    public static int getSelectedTheme() {
        return theme;
    }

    public static void setSelectedTheme(int index) {
        theme = index;
        saveFromCache();
    }

    public static List<Servico> getServicos() {
        return servicos;
    }

    public static Map<Integer, Cliente> getClientes() {
        return clientes;
    }

    public static void registerClient(Cliente cliente) {
        checkLoadedStats();
        cliente.id = nextClientId++;
        clientes.put(cliente.id, cliente);
        System.out.println("[App] Novo cliente registrado!");
    }

    public static void loadToCache() {
        System.out.println("[App] Carregando dados...");
        Quadruple<Map<Integer, Cliente>, List<Servico>, Integer, Integer> entry = load();
        clientes = entry.one;
        servicos = entry.two;
        nextClientId = entry.three;
        theme = entry.four;
        System.out.println("[App] Dados carregados!");
    }

    public static void saveFromCache() {
        System.out.println("[App] Salvando dados...");
        checkLoadedStats();
        save(new Quadruple<>(clientes, servicos, nextClientId, theme));
        System.out.println("[App] Dados salvados!");
    }

    public static Quadruple<Map<Integer, Cliente>, List<Servico>, Integer, Integer> load() {
        if (!FILE.exists()) {
            return new Quadruple<>(new HashMap<>(), new ArrayList<>(), 1, DEFAULT_THEME);
        }

        try ( FileInputStream in = new FileInputStream(FILE);  ObjectInputStream objIn = new ObjectInputStream(in)) {
            return (Quadruple<Map<Integer, Cliente>, List<Servico>, Integer, Integer>) objIn.readObject();
        } catch (Throwable e) {
            System.out.println("[App] Ocorreu um erro ao tentar carregar os dados!");
            e.printStackTrace();
            return new Quadruple<>(new HashMap<>(), new ArrayList<>(), 1, DEFAULT_THEME);
        }
    }

    public static void save(Quadruple<Map<Integer, Cliente>, List<Servico>, Integer, Integer> dados) {
        if (!FILE.exists()) {
            if (FILE.getParentFile() != null) {
                FILE.getParentFile().mkdirs();
            }
            try {
                FILE.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try ( FileOutputStream out = new FileOutputStream(FILE);  ObjectOutputStream oOut = new ObjectOutputStream(out)) {
            oOut.writeObject(dados);
        } catch (Throwable e) {
            System.out.println("[App] Ocorreu um erro ao tentar salvar os dados!");
            e.printStackTrace();
        }
    }

    private static void checkLoadedStats() {
        if (clientes == null || servicos == null) {
            throw new IllegalStateException("Não é possível utilizar a memoria, pois não foi nada carregado");
        }
    }
}
