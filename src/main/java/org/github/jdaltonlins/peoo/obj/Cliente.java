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

/**
 *
 * @author Dalton Lins
 */
public class Cliente implements Datable {

    public int id;
    public String nome, numero, cpf;

    public Cliente(int id, String nome, String numero, String cpf) {
        this.id = id;
        this.nome = nome;
        this.numero = numero;
        this.cpf = cpf;
    }

    public Cliente(Object[] o) {
        this.id = Integer.parseInt(o[0].toString());
        this.nome = o[1].toString();
        this.numero = o[2].toString();
        this.cpf = o[3].toString();
    }

    public Object[] toData() {
        return new Object[]{id, nome, numero, cpf};
    }

}
