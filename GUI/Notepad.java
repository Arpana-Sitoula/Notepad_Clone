package GUI;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import javax.swing.event.DocumentEvent;


public class Notepad {
    Notepad(){
        JFrame f = new JFrame();
        f.setTitle("Notepad");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenu File,Edit,Format,View,Help;
        JMenu zoom;
        JMenuItem New, NewWindow, Open, Save, SaveAs, Pagesetup, print, exit;
        JMenuItem Undo,Cut,Copy,Paste,Delete,Search,Find,FindN,FindP,Replace,Goto,Select,DateTime;
        JMenuItem wordwrap, font;
        JMenuItem zoomin, zoomout, statusbar;
        JMenuItem viewh, sendf,about;
        JMenuBar mb = new JMenuBar();
        JTextArea area = new JTextArea();
        JLabel col = new JLabel();
        JLabel row = new JLabel();

        col.setLayout(new BorderLayout(30,30));
        f.add(col,BorderLayout.SOUTH);
        row.setLayout(new BorderLayout(80,95));
        f.add(row,BorderLayout.SOUTH);
        
            
        
        area.setBounds(0,0,1600,1500);
        f.add(area);
    
        area.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateCharCount();
                updateLineNum();
            }
        
            @Override
            public void removeUpdate(DocumentEvent e) {
                updateCharCount();
                updateLineNum();
            }
        
            @Override
            public void changedUpdate(DocumentEvent e) {
                updateCharCount();
                updateLineNum();
            }
        
            private void updateCharCount() {
                try{
                    int charCount = area.getText().length();
                    col.setText("Col: " + charCount);
                }catch(Error e){
                    e.printStackTrace();
                }
               
            }
    
            private void updateLineNum(){
                try{
                    int offset = area.getCaretPosition();
                    int line = area.getLineOfOffset(offset);
                    row.setText("Row: "+ (line + 1));
                }catch(BadLocationException e){
                    e.printStackTrace();
                }
            }
        });
        
            
       
        //Navbar
        File = new JMenu("File");
        Edit = new JMenu("Edit");
        Format = new JMenu("Format");
        View = new JMenu("View");
        Help = new JMenu("Help");
    
        //Inside File
        New = new JMenuItem("New");
        NewWindow = new JMenuItem("New Window");
        Open = new JMenuItem("Open...");
        Save = new JMenuItem("Save");
        SaveAs = new JMenuItem("Save As");
        Pagesetup = new JMenuItem("Page Setup...");
        print = new JMenuItem("Print...");
        exit = new JMenuItem("Exit");

       
        //Inside Edit
         Undo = new JMenuItem("Undo");
         Cut = new JMenuItem("Cut");
         Copy = new JMenuItem("Copy");
         Paste = new JMenuItem("Paste");
         Delete = new JMenuItem("Delete");
         Search = new JMenuItem("Search with Bing...");
         Find = new JMenuItem("Find...");
         FindN = new JMenuItem("Find Next");
         FindP = new JMenuItem("Find Previous");
         Replace = new JMenuItem("Replace...");
         Goto = new JMenuItem("Go To...");
         Select = new JMenuItem("Select All");
         DateTime = new JMenuItem("Time/Date");
    
        //Inside Format
        wordwrap = new JMenuItem("Word Wrap");
        font = new JMenuItem("Font...");
    
        //Inside View
        zoom = new JMenu("Zoom");
    
        zoomin = new JMenuItem("Zoom In");
        zoomout = new JMenuItem("Zoom Out");
        statusbar = new JMenuItem("Status Bar");
    
        //Inside Help
        viewh = new JMenuItem("View Help");
        sendf = new JMenuItem("Send Feedback");
        about = new JMenuItem("About Notepad");
    
    
        File.add(New);
        File.add(NewWindow);
        File.add(Open);
        File.add(Save);
        File.add(SaveAs);
        File.add(Pagesetup);
        File.add(print);
        File.add(exit);

        Edit.add(Undo);
        Edit.add(Cut);
        Edit.add(Copy);
        Edit.add(Paste);
        Edit.add(Delete);
        Edit.add(Search);
        Edit.add(Find);
        Edit.add(FindN);
        Edit.add(FindP);
        Edit.add(Replace);
        Edit.add(Goto);
        Edit.add(Select);
        Edit.add(DateTime); 

    
        Format.add(wordwrap);
        Format.add(font);
    
        View.add(zoom);
        View.add(statusbar);
    
        zoom.add(zoomin);
        zoom.add(zoomout);

        Help.add(viewh);
        Help.add(sendf);
        Help.add(about);
    
        mb.add(File);
        mb.add(Edit);
        mb.add(Format);
        mb.add(View);
        mb.add(Help);
    
        f.setJMenuBar(mb);
    
        f.setSize(500,500);
        f.setVisible(true);
        
      }  
    
  public static void main(String[] args) {
    new Notepad();
}
}
