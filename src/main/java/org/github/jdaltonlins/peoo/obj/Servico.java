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
package org.github.jdaltonlins.peoo.obj;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.github.jdaltonlins.peoo.ui.JTabela;
import org.github.jdaltonlins.peoo.utils.Manager;
import org.github.jdaltonlins.peoo.utils.Utils;

/**
 *
 * @author Dalton
 */
public class Servico implements Datable {

    public int clienteId;
    public List<String> servicos;
    public long date;

    public Servico(int clienteId, List<String> servicos, long date) {
        this.clienteId = clienteId;
        this.servicos = servicos;
        this.date = date;
    }

    public Servico(Object[] o) {
        try {
            String s = o[0].toString();
            if (s.contains("#")) {
                this.clienteId = Integer.parseInt(s.substring(s.lastIndexOf("#") + 1));
            } else {
                this.clienteId = 0;
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        
        try {
            this.date = JTabela.DATE_FORMAT.parse(o[1].toString()).getTime();
        } catch (ParseException ex) {
            Logger.getLogger(Servico.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            System.out.println(o[2].toString());
            List<String> list = new ArrayList<>(Arrays.asList(o[2].toString().split(", ")));
            if (list.size() > 0) {
                String[] splits = list.remove(list.size() - 1).split(" e ");
                list.add(splits[0]);
                list.add(splits[1]);
            }
            this.servicos = list;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object[] toData() {
        Cliente client = Manager.getClientes().get(this.clienteId);
        return new Object[]{client != null ? client.nome + "#" + client.id : "Inválido", JTabela.DATE_FORMAT.format(date), Utils.toJoin(servicos)};
    }

}
