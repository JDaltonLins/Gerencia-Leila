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

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import org.github.jdaltonlins.peoo.obj.Cliente;
import org.github.jdaltonlins.peoo.utils.Manager;
import org.github.jdaltonlins.peoo.utils.Utils;

/**
 *
 * @author Dalton
 */
public class JNovoCliente extends Backable {

    /**
     * Creates new form JNovoCliente
     */
    public JNovoCliente() {
        this(null);
    }

    public JNovoCliente(JFrame frame) {
        super(frame);
        initComponents();
        active();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleName = new javax.swing.JLabel();
        inputName = new javax.swing.JTextField();
        titleNumero = new javax.swing.JLabel();
        inputNumero = new javax.swing.JFormattedTextField();
        titleCpf = new javax.swing.JLabel();
        inputCPF = new javax.swing.JFormattedTextField();
        confirmBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Cliente");
        setResizable(false);

        titleName.setLabelFor(inputName);
        titleName.setText("<html>Nome: <a color=\"#f34336\">*</a></html>");

        inputName.setToolTipText("Nome do Cliente");
        inputName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                onInputColor(evt);
            }
        });

        titleNumero.setLabelFor(inputNumero);
        titleNumero.setText("Numero:");
        titleNumero.setMaximumSize(new java.awt.Dimension(33, 14));
        titleNumero.setMinimumSize(new java.awt.Dimension(33, 14));

        try {
            inputNumero.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        inputNumero.setToolTipText("Numero do Cliente");
        inputNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                onInputColor(evt);
            }
        });

        titleCpf.setLabelFor(inputCPF);
        titleCpf.setText("CPF:");
        titleCpf.setMaximumSize(new java.awt.Dimension(33, 14));
        titleCpf.setMinimumSize(new java.awt.Dimension(33, 14));

        try {
            inputCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        inputCPF.setToolTipText("CPF do Cliente");
        inputCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                onInputColor(evt);
            }
        });

        confirmBtn.setText("Cadastrar");
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onSave(evt);
            }
        });

        cancelBtn.setText("Cancelar");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onCancel(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(titleName)
                    .addComponent(titleCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputNumero)
                    .addComponent(inputCPF, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelBtn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmBtn)
                    .addComponent(cancelBtn))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void onInputColor(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_onInputColor
        JTextField field = (JTextField) evt.getSource();
        field.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
    }//GEN-LAST:event_onInputColor

    private void onSave(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onSave
        if (this.inputName.getText().trim().length() == 0) {
            inputName.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            if (JOptionPane.showConfirmDialog(this, "É necessário preencher o nome do cliente!", "Ops! Você esqueceu de algo.", JOptionPane.ERROR_MESSAGE) != JOptionPane.OK_OPTION) {
                this.dispose();
                return;
            }
        }

        List<String> erros = new ArrayList<>();
        String numero = this.inputNumero.getText();
        if (numero.replaceAll("[\\(\\)-]", "").trim().length() > 0 && !this.inputNumero.isEditValid()) {
            inputNumero.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            erros.add("Número");
            numero = "";
        }
        String cpf = this.inputCPF.getText();
        if (cpf.replaceAll("[\\.-]", "").trim().length() > 0 && !this.inputNumero.isEditValid()) {
            inputCPF.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            erros.add("CPF");
            cpf = "";
        }

        if (erros.size() > 0) {
            String errosStr = Utils.toJoin(erros);
            boolean plural = erros.size() > 1;
            if (JOptionPane.showConfirmDialog(this, "Você precisa preencher corretamente "
                    + (plural ? "os " : "o ")
                    + "campo" + (plural ? "s" : "")
                    + ": "
                    + errosStr, "Ops! Você esqueceu de algo.", JOptionPane.ERROR_MESSAGE) != JOptionPane.OK_OPTION) {
                this.dispose();
            }
            return;
        }

        Cliente cliente = new Cliente(0, this.inputName.getText(), numero, cpf);
        Manager.registerClient(cliente);
        Manager.saveFromCache();
        this.dispose();
    }//GEN-LAST:event_onSave

    private void onCancel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onCancel
        this.dispose();
    }//GEN-LAST:event_onCancel

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JFormattedTextField inputCPF;
    private javax.swing.JTextField inputName;
    private javax.swing.JFormattedTextField inputNumero;
    private javax.swing.JLabel titleCpf;
    private javax.swing.JLabel titleName;
    private javax.swing.JLabel titleNumero;
    // End of variables declaration//GEN-END:variables
}