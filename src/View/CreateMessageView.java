/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.FeedController;

/**
 *
 * @author Frederik
 */
public class CreateMessageView extends javax.swing.JFrame {

    private FeedController fcontroller; 
    
    
    /**
     * Creates new form CreateMessageView
     */
    public CreateMessageView(FeedController feedController) {
        initComponents();
        this.fcontroller = feedController;
        this.titleLabel.setText("Enter title on the message below");
        this.descriptionLabel.setText("Enter description on the message below");
        this.addMessageButton.setText("Add message");
        this.insertIntoDBButton.setText("Insert to DB");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        titleArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        descriptionArea = new javax.swing.JTextArea();
        titleLabel = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();
        addMessageButton = new javax.swing.JButton();
        insertIntoDBButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleArea.setColumns(20);
        titleArea.setRows(5);
        jScrollPane1.setViewportView(titleArea);

        descriptionArea.setColumns(20);
        descriptionArea.setRows(5);
        jScrollPane2.setViewportView(descriptionArea);

        titleLabel.setText("jLabel1");

        descriptionLabel.setText("jLabel2");

        addMessageButton.setText("jButton1");
        addMessageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMessageButtonActionPerformed(evt);
            }
        });

        insertIntoDBButton.setText("jButton2");
        insertIntoDBButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertIntoDBButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(insertIntoDBButton)
                            .addComponent(addMessageButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descriptionLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(titleLabel))))
                .addContainerGap(188, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(descriptionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addMessageButton)
                .addGap(31, 31, 31)
                .addComponent(insertIntoDBButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addMessageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMessageButtonActionPerformed
        this.fcontroller.addMessageToFeed(this.titleArea.getText(), this.descriptionArea.getText());
        this.titleArea.setText("");
        this.descriptionArea.setText("");
    }//GEN-LAST:event_addMessageButtonActionPerformed

    private void insertIntoDBButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertIntoDBButtonActionPerformed
        this.fcontroller.insertFeedToDB();
        this.titleArea.setText("");
        this.descriptionArea.setText("");
    }//GEN-LAST:event_insertIntoDBButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMessageButton;
    private javax.swing.JTextArea descriptionArea;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JButton insertIntoDBButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea titleArea;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
