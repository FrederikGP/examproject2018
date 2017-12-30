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
public class CreateFeedView extends javax.swing.JFrame {

    /**
     * Creates new form createFeedView
     */
    
    private FeedController fController;
    public CreateFeedView() {
        initComponents();
        this.fController = new FeedController();
        
        this.titleLabel.setText("Enter title below");
        this.linkLabel.setText("Enter link below");
        this.descriptionLabel.setText("Enter description below");
        this.languageLabel.setText("Enter language below");
        this.createFeedButton.setText("Create feed");
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
        linkArea = new javax.swing.JTextArea();
        createFeedButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        linkLabel = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        descriptionArea = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        languageArea = new javax.swing.JTextArea();
        languageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleArea.setColumns(20);
        titleArea.setRows(5);
        jScrollPane1.setViewportView(titleArea);

        linkArea.setColumns(20);
        linkArea.setRows(5);
        jScrollPane2.setViewportView(linkArea);

        createFeedButton.setText("jButton1");
        createFeedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createFeedButtonActionPerformed(evt);
            }
        });

        titleLabel.setText("jLabel1");

        linkLabel.setText("jLabel1");

        descriptionLabel.setText("jLabel1");

        descriptionArea.setColumns(20);
        descriptionArea.setRows(5);
        jScrollPane3.setViewportView(descriptionArea);

        languageArea.setColumns(20);
        languageArea.setRows(5);
        jScrollPane4.setViewportView(languageArea);

        languageLabel.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descriptionLabel))
                        .addGap(124, 124, 124)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(languageLabel)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(linkLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(createFeedButton)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(linkLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(76, 76, 76)
                        .addComponent(descriptionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(createFeedButton)
                        .addGap(65, 65, 65))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(languageLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(169, 169, 169))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createFeedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createFeedButtonActionPerformed
        this.fController.createFeed(this.titleArea.getText(), this.linkArea.getText(), this.descriptionArea.getText(), this.languageArea.getText());
        CreateMessageView frame = new CreateMessageView(this.fController);
        frame.setBounds(100,100,500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
        
        this.titleArea.setText("");
        this.linkArea.setText("");
        this.descriptionArea.setText("");
        this.languageArea.setText("");
    }//GEN-LAST:event_createFeedButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createFeedButton;
    private javax.swing.JTextArea descriptionArea;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea languageArea;
    private javax.swing.JLabel languageLabel;
    private javax.swing.JTextArea linkArea;
    private javax.swing.JLabel linkLabel;
    private javax.swing.JTextArea titleArea;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
