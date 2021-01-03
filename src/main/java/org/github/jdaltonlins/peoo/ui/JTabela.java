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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.DefaultCellEditor;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import org.github.jdaltonlins.peoo.utils.Manager;
import org.github.jdaltonlins.peoo.obj.*;

/**
 *
 * @author Dalton
 */
public class JTabela extends Backable {

    public static DateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

    private boolean clientMode;

    /**
     * Creates new form JTabela
     *
     * @param back
     * @param clientMode
     */
    public JTabela(JFrame back, boolean clientMode) {
        super(back);
        this.initComponents();
        this.switchMode(this.clientMode = clientMode);
        this.active();
    }

    public JFormattedTextField newFormmated(String format) {
        JFormattedTextField field = new JFormattedTextField();
        try {
            field.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter(format)));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        return field;
    }

    public class TableCellRenderer extends DefaultCellEditor {

        public TableCellRenderer(String format) {
            super(newFormmated(format));
        }

        @Override
        public boolean stopCellEditing() {
            JFormattedTextField field = (JFormattedTextField) getComponent();
            return (field.isEditValid() || field.getText().replaceAll("[\\.-\\(\\)]", "").trim().length() == 0) && super.stopCellEditing(); //To change body of generated methods, choose Tools | Templates.
        }
    }

    public void switchMode(boolean clientMode) {
        if (clientMode) {
            this.switchBtn.setText("Ver serviços");
            this.updateBtn.setText("Atualizar clientes");
            this.newBtn.setText("Novo cliente");
            this.saveBtn.setText("Salvar clientes");

            Object[][] data = Manager.getClientes().values().stream().map(Cliente::toData).collect(Collectors.toList()).toArray(new Object[0][]);
            this.infoLabel.setText("Total de registros: " + data.length);

            table.setModel(new javax.swing.table.DefaultTableModel(
                    data,
                    new String[]{"ID", "Nome", "Número", "CPF"}
            ) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return column != 0;
                }
            });
            TableColumnModel tC = table.getColumnModel();
            tC.getColumn(2).setCellEditor(new TableCellRenderer("(##) #####-####"));
            tC.getColumn(3).setCellEditor(new TableCellRenderer("###.###.###-##"));
        } else {
            this.switchBtn.setText("Ver clientes");
            this.updateBtn.setText("Atualizar serviços");
            this.newBtn.setText("Novo serviço");
            this.saveBtn.setText("Salvar serviços");

            Object[][] data = Manager.getServicos().stream().map(Servico::toData).collect(Collectors.toList()).toArray(new Object[0][]);
            this.infoLabel.setText("Total de registros: " + data.length);

            table.setModel(new javax.swing.table.DefaultTableModel(
                    data,
                    new String[]{"Cliente", "Horário/Dia", "Serviços"}
            ) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return column != 0;
                }
            });
            TableColumnModel tC = table.getColumnModel();
            JFormattedTextField txt = newFormmated("##:##:## ##/##/####");

            JFrame frame = this;
            tC.getColumn(1).setCellEditor(new DefaultCellEditor(txt) {
                @Override
                public boolean stopCellEditing() {
                    if (txt.isEditValid()) {
                        try {
                            Date date = DATE_FORMAT.parse(txt.getName());
                            if (System.currentTimeMillis() > date.getTime()) {
                                JOptionPane.showMessageDialog(frame, "Você precisa alterar com um tempo futuro");
                                return false;
                            }
                        } catch (Throwable e) {

                        }
                        return super.stopCellEditing();
                    }
                    return false;
                }

            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tablePane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        infoLabel = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        switchBtn = new javax.swing.JButton();
        newBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablePane.setViewportView(table);

        infoLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infoLabel.setText("Total de registros:");

        backBtn.setText("Voltar para o Menu");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onBack(evt);
            }
        });

        saveBtn.setText("Salvar agenda");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onSave(evt);
            }
        });

        updateBtn.setText("Atualizar agenda");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onUpdate(evt);
            }
        });

        switchBtn.setText("Ver clientes");
        switchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onSwitch(evt);
            }
        });

        newBtn.setText("Novo serviço");
        newBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onNewer(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tablePane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(backBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(infoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(updateBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(newBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(switchBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saveBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tablePane, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(switchBtn)
                    .addComponent(infoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(newBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(saveBtn)
                    .addComponent(updateBtn))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void onBack(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onBack
        this.dispose();
    }//GEN-LAST:event_onBack

    private void onSave(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onSave
        if (this.clientMode) {
            System.out.println("[UI] Convertendo clientes...");
            Map<Integer, Cliente> clientes = new HashMap<>();
            TableModel model = this.table.getModel();
            for (int row = 0, rows = model.getRowCount(); row < rows; row++) {
                Cliente cliente = new Cliente((int) model.getValueAt(row, 0), (String) model.getValueAt(row, 1), (String) model.getValueAt(row, 2), (String) model.getValueAt(row, 3));
                clientes.put(cliente.id, cliente);
            }
            Map<Integer, Cliente> cached = Manager.getClientes();
            cached.clear();
            cached.putAll(clientes);
            System.out.println("[UI] Conversão de clientes completo.");
            Manager.saveFromCache();
        } else {
            System.out.println("[UI] Convertendo serviços...");
            List<Servico> servicos = new ArrayList<>();
            TableModel model = this.table.getModel();
            for (int row = 0, rows = model.getRowCount(); row < rows; row++) {
                Servico servico = new Servico(new Object[]{model.getValueAt(row, 0), model.getValueAt(row, 1), model.getValueAt(row, 2)});
                servicos.add(servico);
            }
            List<Servico> cached = Manager.getServicos();
            cached.clear();
            cached.addAll(servicos);
            System.out.println("[UI] Conversão de serviços completo.");
            Manager.saveFromCache();
        }
    }//GEN-LAST:event_onSave

    private void onSwitch(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onSwitch
        this.switchMode(this.clientMode = !this.clientMode);
    }//GEN-LAST:event_onSwitch

    private void onUpdate(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onUpdate
        switchMode(this.clientMode);
    }//GEN-LAST:event_onUpdate

    private void onNewer(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onNewer
        if (this.clientMode)
            new JNovoCliente(this);
        else
            new JNovoServico(this);
    }//GEN-LAST:event_onNewer

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JButton newBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton switchBtn;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tablePane;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
