/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometria1;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.awt.image.Raster;
import java.awt.image.ShortLookupTable;
import java.util.Arrays;

/**
 *
 * @author rryk
 */
public class HistogramFrame extends javax.swing.JFrame {

    /**
     * Creates new form Histogram
     */
    ImageBoxer imageBoxer;    
    short histR[];
    short histG[];
    short histB[];
    short histRGB[];
    short blank[];
    //short data[][];
    LookupOp lookup;
    public HistogramFrame(ImageBoxer Boxer) {
        super("Histogram");
        initComponents();
        histR=new short[256];
        histG=new short[256];
        histB=new short[256];
        blank=new short[256];
        Arrays.fill(histR, (short)0);
        Arrays.fill(histG, (short)0);
        Arrays.fill(histB, (short)0);
        Arrays.fill(blank, (short)0);

        //data = new short[3][256];
        //data ={histR; blank; blank};
        histRGB=new short[256];
        imageBoxer = Boxer;
    }
    private int getMax(short hist[]){
        int tempmax=0;
        for (int i=0; i<256;i++){
            if(hist[i]>tempmax)tempmax=hist[i];
        }
        return tempmax;
    }
    private void rysujWykres(ImageBoxer z, short hist[], Color c){
    int tempmax=getMax(hist);
    BufferedImage h=new BufferedImage(256+1,tempmax+1,BufferedImage.TYPE_INT_ARGB);
    for(int i=0; i<256; i++){
        for(int j=tempmax-hist[i];j<tempmax;j++){
            h.setRGB(i,j, c.getRGB());
        }
    }
   // z.image=null;
    z.image=h;
    z.scalexy=true;
    z.scaley=1.0/(((double)tempmax/(double)z.getHeight()));
    //System.out.println(z.scaley+" "+tempmax+" "+z.getHeight());
    
    z.repaint();
    }
    private void przyciemnij(){
        short[] red = new short[256];
        short[] green = new short[256];
        short[] blue = new short[256];
        for (short i = 0; i < 256; i++) {

            if(i>200)red[i]=green[i]=blue[i] = (short) (i-Math.log(i));
            else{
                red[i]=green[i]=blue[i]=i;
            }
        }

        short[][] data = new short[][] {
             red, green, blue
        };
        
                LookupTable lookupTable = new ShortLookupTable(0, data);
                LookupOp op = new LookupOp(lookupTable, null);
                imageBoxer.image=ImageBoxer.convertColorspace(imageBoxer.image,BufferedImage.TYPE_INT_RGB);
                imageBoxer.image=op.filter(imageBoxer.image, null);
                imageBoxer.repaint();
    }
    private void przytnij(){
        short a=3;
        short b=252;
        short[] red = new short[256];
        short[] green = new short[256];
        short[] blue = new short[256];
        for (short i = 0; i < 256; i++) {

            //if((i>a)&&(i<b)){
                //red[i]=green[i]=blue[i]=i;
                                short k=(short)(((255-b)-(i%(255-b)))-(a-(i%a)));
                System.out.println(i+" "+k);
                if(i<(short)((a+b)/2)){
                    if(i-(a-(i%a))>0) red[i]=green[i]=blue[i]=(short)(i-(a-(i%a)));
                    else red[i]=green[i]=blue[i]=(short)0;
                }
                else {
                    if(i+((255-b)-(i%(255-b)))<256)red[i]=green[i]=blue[i]=(short)(i+((255-b)-(i%(255-b))));
                    else red[i]=green[i]=blue[i]=(short)256;
                }
            //}
            //else{
             //  red[i]=green[i]=blue[i]=(short)(255-i);

            //}
        }

        short[][] data = new short[][] {
             red, green, blue
        };
                LookupTable lookupTable = new ShortLookupTable(0, data);
                LookupOp op = new LookupOp(lookupTable, null);            
                imageBoxer.image=ImageBoxer.convertColorspace(imageBoxer.image,BufferedImage.TYPE_INT_RGB);
                //BufferedImage temp=imageBoxer.image;
                imageBoxer.image=op.filter(imageBoxer.image, imageBoxer.image);
                imageBoxer.repaint();
    }
    
    private void przelicz(){
                Color temp;
                Arrays.fill(histR, (short)0);
                Arrays.fill(histG, (short)0);
                Arrays.fill(histB, (short)0);
                Arrays.fill(histRGB, (short)0);
                for (int j=0; j<imageBoxer.image.getHeight(); j++){
                    for (int i=0; i<imageBoxer.image.getWidth();i++){
                        temp=new Color(imageBoxer.image.getRGB(i, j));
                        histR[temp.getRed()]++;
                        histG[temp.getGreen()]++;
                        histB[temp.getBlue()]++;
                        histRGB[(temp.getRed()+temp.getGreen()+temp.getBlue())/3]++;
                    }
                }
                rysujWykres(hR,histR,Color.RED);
                rysujWykres(hG,histG,Color.GREEN);
                rysujWykres(hB,histB,Color.BLUE);
                rysujWykres(hRGB,histRGB,Color.BLACK);
                
                //hR.image=new BufferedImage(255,getMax(histR),BufferedImage.TYPE_INT_ARGB);
                //hG.image=new BufferedImage(255,getMax(histG),BufferedImage.TYPE_INT_ARGB);
                //hB.image=new BufferedImage(255,getMax(histB),BufferedImage.TYPE_INT_ARGB);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageBoxer2 = new biometria1.ImageBoxer();
        jLabel1 = new javax.swing.JLabel();
        hR = new biometria1.ImageBoxer();
        jLabel2 = new javax.swing.JLabel();
        hG = new biometria1.ImageBoxer();
        jLabel3 = new javax.swing.JLabel();
        hB = new biometria1.ImageBoxer();
        jLabel4 = new javax.swing.JLabel();
        hRGB = new biometria1.ImageBoxer();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        javax.swing.GroupLayout imageBoxer2Layout = new javax.swing.GroupLayout(imageBoxer2);
        imageBoxer2.setLayout(imageBoxer2Layout);
        imageBoxer2Layout.setHorizontalGroup(
            imageBoxer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        imageBoxer2Layout.setVerticalGroup(
            imageBoxer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Histogram Red");

        hR.setMinimumSize(new java.awt.Dimension(255, 100));
        hR.setPreferredSize(new java.awt.Dimension(255, 100));

        javax.swing.GroupLayout hRLayout = new javax.swing.GroupLayout(hR);
        hR.setLayout(hRLayout);
        hRLayout.setHorizontalGroup(
            hRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );
        hRLayout.setVerticalGroup(
            hRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel2.setText("Histogram Green");

        javax.swing.GroupLayout hGLayout = new javax.swing.GroupLayout(hG);
        hG.setLayout(hGLayout);
        hGLayout.setHorizontalGroup(
            hGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        hGLayout.setVerticalGroup(
            hGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel3.setText("Histogram Blue");

        javax.swing.GroupLayout hBLayout = new javax.swing.GroupLayout(hB);
        hB.setLayout(hBLayout);
        hBLayout.setHorizontalGroup(
            hBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        hBLayout.setVerticalGroup(
            hBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel4.setText("HistogramRGB");

        javax.swing.GroupLayout hRGBLayout = new javax.swing.GroupLayout(hRGB);
        hRGB.setLayout(hRGBLayout);
        hRGBLayout.setHorizontalGroup(
            hRGBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );
        hRGBLayout.setVerticalGroup(
            hRGBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton1.setText("Przelicz");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(hR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(hG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(hB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(hRGB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hR, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(hRGB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        przelicz();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        przytnij();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private biometria1.ImageBoxer hB;
    private biometria1.ImageBoxer hG;
    private biometria1.ImageBoxer hR;
    private biometria1.ImageBoxer hRGB;
    private biometria1.ImageBoxer imageBoxer2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
