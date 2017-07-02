import java.util.regex.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Font;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;





public class Calculator extends JFrame{
	
	JButton but0,but1,but2,but3,but4,but5,but6,but7,but8,but9,
	point,clear,plus,minus,multi,divide,enter;
	
	JTextArea resultArea;
	
	double number1,number2,total,subTotal;
	double initValue = 0;
	String actionToPerform="";
	int pointsPressed = 0;
	int currentLine = 1;
	
	
	boolean performAction = false;
	
	public static void main(String[] args){
		
		new Calculator();
		
	}
	
	public Calculator(){
		
		Dimension size = new Dimension();
		size.width =400;
		size.height = 700;
		
		this.setSize(size);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Calculator");
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		
		
		
		
		resultArea = new JTextArea(2,20);
		resultArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		resultArea.setText("0");
		Font font = new Font("Helvetica",Font.BOLD,18);
		resultArea.setFont(font);
		resultArea.setEditable(false);
		JScrollPane scrollBar = new JScrollPane(resultArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		but0 = new JButton("0");
		but0.setFocusable(false);
		but1 = new JButton("1");
		but1.setFocusable(false);
		but2 = new JButton("2");
		but2.setFocusable(false);
		but3 = new JButton("3");
		but3.setFocusable(false);
		but4 = new JButton("4");
		but4.setFocusable(false);
		but5 = new JButton("5");
		but5.setFocusable(false);
		but6 = new JButton("6");
		but6.setFocusable(false);
		but7 = new JButton("7");
		but7.setFocusable(false);
		but8 = new JButton("8");
		but8.setFocusable(false);
		but9 = new JButton("9");
		but9.setFocusable(false);
		point = new JButton(".");
		point.setFocusable(false);
		plus = new JButton("+");
		plus.setFocusable(false);
		minus = new JButton("-");
		minus.setFocusable(false);
		multi = new JButton("*");
		multi.setFocusable(false);
		divide = new JButton("/");
		divide.setFocusable(false);
		clear = new JButton("C");
		clear.setFocusable(false);
		enter = new JButton("=");
		enter.setFocusable(false);
		
		GridBagConstraints gridBagConstraint  = new GridBagConstraints();
		
		gridBagConstraint.insets = new Insets(5,5,5,5);
		
		
		gridBagConstraint.gridx =1;
		gridBagConstraint.gridy = 1;
		gridBagConstraint.gridheight = 2;
		gridBagConstraint.gridwidth = 4;
		gridBagConstraint.weightx = 1;
		gridBagConstraint.weighty = 1;
		
		gridBagConstraint.fill = GridBagConstraints.BOTH;
		gridBagConstraint.anchor = GridBagConstraints.CENTER;
		
		mainPanel.add(scrollBar, gridBagConstraint);
		gridBagConstraint.gridheight = 1;
		gridBagConstraint.gridwidth = 1;
		gridBagConstraint.gridy = 3;
		mainPanel.add(clear, gridBagConstraint);
		gridBagConstraint.gridx = 2;
		mainPanel.add(divide, gridBagConstraint);
		gridBagConstraint.gridx = 3;
		mainPanel.add(multi, gridBagConstraint);
		gridBagConstraint.gridx = 4;
		mainPanel.add(minus, gridBagConstraint);
		gridBagConstraint.gridy = 4;
		gridBagConstraint.gridx = 1;
		mainPanel.add(but7, gridBagConstraint);
		gridBagConstraint.gridx = 2;
		mainPanel.add(but8, gridBagConstraint);
		gridBagConstraint.gridx = 3;
		mainPanel.add(but9, gridBagConstraint);
		gridBagConstraint.gridx = 4;
		gridBagConstraint.gridheight = 2;
		mainPanel.add(plus, gridBagConstraint);
		gridBagConstraint.gridy = 5;
		gridBagConstraint.gridx = 1;
		gridBagConstraint.gridheight = 1;
		mainPanel.add(but4, gridBagConstraint);
		gridBagConstraint.gridx = 2;
		mainPanel.add(but5, gridBagConstraint);
		gridBagConstraint.gridx = 3;
		mainPanel.add(but6, gridBagConstraint);
		gridBagConstraint.gridy = 6;
		gridBagConstraint.gridx = 4;
		gridBagConstraint.gridheight = 2;
		mainPanel.add(enter, gridBagConstraint);
		gridBagConstraint.gridheight = 1;
		gridBagConstraint.gridx = 3;
		mainPanel.add(but3, gridBagConstraint);
		gridBagConstraint.gridx = 2;
		mainPanel.add(but2, gridBagConstraint);
		gridBagConstraint.gridx = 1;
		mainPanel.add(but1, gridBagConstraint);
		gridBagConstraint.gridwidth = 2;
		gridBagConstraint.gridy = 7;
		mainPanel.add(but0,gridBagConstraint);
		gridBagConstraint.gridwidth = 1;
		gridBagConstraint.gridx = 3;
		mainPanel.add(point,gridBagConstraint);
		
		
		ListenForKeys lForKeys = new ListenForKeys();
		
		resultArea.addKeyListener(lForKeys);
	
		
		
		ListenForButton lForButton = new ListenForButton();
		but0.addActionListener(lForButton);
		but1.addActionListener(lForButton);
		but2.addActionListener(lForButton);
		but3.addActionListener(lForButton);
		but4.addActionListener(lForButton);
		but5.addActionListener(lForButton);
		but6.addActionListener(lForButton);
		but7.addActionListener(lForButton);
		but8.addActionListener(lForButton);
		but9.addActionListener(lForButton);
		point.addActionListener(lForButton);
		clear.addActionListener(lForButton);
		plus.addActionListener(lForButton);
		minus.addActionListener(lForButton);
		divide.addActionListener(lForButton);
		multi.addActionListener(lForButton);
		enter.addActionListener(lForButton);
	
		this.add(mainPanel);
		this.setVisible(true);
	};
	
	
	private class ListenForButton implements ActionListener{
		
		String areaText =(String) resultArea.getText();
		
		public void actionPerformed(ActionEvent e){
			
			if(e.getSource() == but0 ||e.getSource() == but1 ||e.getSource() == but2 ||e.getSource() == but3 ||
			   e.getSource() == but4 ||e.getSource() == but5 ||e.getSource() == but6 ||e.getSource() == but7 ||
			   e.getSource() == but8 ||e.getSource() == but9){
			
				
				
				if(initValue == 0){
					
					resultArea.setText(e.getActionCommand());
					areaText =(String) resultArea.getText();
					initValue = 1;
					//performAction = true;
					
				
				}else if(initValue == 2){
				
					
					int caretOffset = resultArea.getCaretPosition();
					
					try {
						int lineNumber = resultArea.getLineOfOffset(caretOffset);
						int startOffset = resultArea.getLineStartOffset(lineNumber);
						int endOffset = resultArea.getLineEndOffset(lineNumber);
						
						if(number1 != 0){
						   resultArea.replaceRange(e.getActionCommand(),startOffset, endOffset);						   	
						   performAction = true;
						
						}else if(number1 == 0 && currentLine == 2){
							
							resultArea.setText(e.getActionCommand());
							currentLine = 1;
							performAction = false;
							
						}
						 
					} 
					catch (BadLocationException e1) {
					
						e1.printStackTrace();
					}
					
					initValue = 1;					
				}else{
								
					resultArea.append(e.getActionCommand());
					performAction = true;
										
				};
				
			}else if(e.getSource() == point){
				
				
				if(pointsPressed == 0 && initValue <= 1){
					
					resultArea.append(e.getActionCommand());					
										
				}else if(pointsPressed == 0 && initValue == 2){
					
					System.out.println("here");
					
					if(number1 != 0){
						
						int caretPosition = resultArea.getCaretPosition();
					
						try{
							
							int lineNumber = resultArea.getLineOfOffset(caretPosition);
							int startOffset = resultArea.getLineStartOffset(lineNumber);
							int endOffset = resultArea.getLineEndOffset(lineNumber);
							
							resultArea.replaceRange("0"+e.getActionCommand(), startOffset, endOffset);
														
						}
						
						catch(BadLocationException e2){
							
							e2.printStackTrace();
						}
					
					}else if(number1 == 0 &&  currentLine == 2){

						System.out.println("here");	
						resultArea.setText("0"+e.getActionCommand());
													
					}
				}
		
				initValue = 1;
				pointsPressed++;
			}else if(e.getSource() == clear){
								
				initValue = 0;
				currentLine =1;
				number1 =0;
				number2=0;
				total = 0;
				subTotal =0;
				actionToPerform = "";
				performAction = false;
				pointsPressed = 0;
				resultArea.setText("0");
								
			}else if(e.getSource() == plus){
				
				
				if(currentLine == 1){
				
				number1 = Double.parseDouble(resultArea.getText());
				areaText = (String) resultArea.getText();
				resultArea.append("+\n"+areaText);
							
				}else if(performAction){
					
					int caretPosition = resultArea.getCaretPosition();
					
					try{
						
						int lineOffset = resultArea.getLineOfOffset(caretPosition);
						int startOffSet = resultArea.getLineStartOffset(lineOffset);
						
						number2 = Double.parseDouble(resultArea.getText().substring(startOffSet));
						
						if(actionToPerform == "+"){
						
							subTotal = number1+number2;
							number1 = subTotal;						
							resultArea.append("+\n"+subTotal);
							
							
						}else if(actionToPerform == "-"){
							
							subTotal = number1-number2;
							number1 = subTotal;						
							resultArea.append("-\n"+subTotal);
							
							
						}else if(actionToPerform == "/"){
							
							subTotal = number1/number2;
							number1 = subTotal;						
							resultArea.append("/\n"+subTotal);
							
						}else if(actionToPerform == "*"){
							
							subTotal = number1*number2;
							number1 = subTotal;						
							resultArea.append("*\n"+subTotal);
							
						}
						
						
												
					}
					
					catch(BadLocationException e4){
						
						e4.printStackTrace();
						
					}
				}
				
					currentLine++;
					initValue = 2;
					pointsPressed = 0;
					performAction =false;
					actionToPerform ="+";
			}else if(e.getSource() == minus){
				
				
				
				if(currentLine == 1){
					
					number1 = Double.parseDouble(resultArea.getText());
					areaText = (String) resultArea.getText();
					resultArea.append("-\n"+areaText);		
					
				}else if(performAction == true){
					
					int caretPosition = resultArea.getCaretPosition();
					
					try{
						
						int lineNumber = resultArea.getLineOfOffset(caretPosition);
						int startOffset = resultArea.getLineStartOffset(lineNumber);
						
						number2 = Double.parseDouble(resultArea.getText().substring(startOffset));
						
						if(actionToPerform == "+"){
							
							subTotal = number1+number2;
							number1 = subTotal;						
							resultArea.append("+\n"+subTotal);
							
							
						}else if(actionToPerform == "-"){
							
							subTotal = number1-number2;
							number1 = subTotal;						
							resultArea.append("-\n"+subTotal);
							
							
						}else if(actionToPerform == "/"){
							
							subTotal = number1/number2;
							number1 = subTotal;						
							resultArea.append("/\n"+subTotal);
							
						}else if(actionToPerform == "*"){
							
							subTotal = number1*number2;
							number1 = subTotal;						
							resultArea.append("*\n"+subTotal);
							
						}
					}
					
					catch(BadLocationException e6){
						
						e6.printStackTrace();
						
					}
					
									
				}
				
				initValue = 2;
				pointsPressed = 0;
				currentLine++;
				performAction =false;					
				actionToPerform = "-";
			}else if(e.getSource() == divide){
				
				if(currentLine == 1){
					
					number1 = Double.parseDouble(resultArea.getText());
					resultArea.append("/\n"+number1);
					initValue = 2;
					pointsPressed = 0;
					currentLine++;
					
				}else if(performAction) {
					
					int caretPosition = resultArea.getCaretPosition();
					
					try{
						
						int lineNumber = resultArea.getLineOfOffset(caretPosition);
						int startOffset = resultArea.getLineStartOffset(lineNumber);
						number2 = Double.parseDouble(resultArea.getText().substring(startOffset));
						
						if(actionToPerform == "+"){
							
							subTotal = number1+number2;
							number1 = subTotal;						
							resultArea.append("+\n"+subTotal);
							
							
						}else if(actionToPerform == "-"){
							
							subTotal = number1-number2;
							number1 = subTotal;						
							resultArea.append("-\n"+subTotal);
							
							
						}else if(actionToPerform == "/"){
							
							subTotal = number1/number2;
							number1 = subTotal;						
							resultArea.append("/\n"+subTotal);
							
						}else if(actionToPerform == "*"){
							
							subTotal = number1*number2;
							number1 = subTotal;						
							resultArea.append("*\n"+subTotal);
							
						}
						
					}
					
					catch(BadLocationException e7){
						
					}
					
					initValue = 2;
					pointsPressed = 0;
					performAction =false;
					
					
				}
				
				
				actionToPerform = "/";
				
			}else if(e.getSource() == multi){
								
				if(currentLine == 1){
					
					number1 = Double.parseDouble(resultArea.getText());
					resultArea.append("*\n"+number1);
					initValue =2;
					currentLine++;
					pointsPressed = 0;
				
				}else{
					
					int caretPosition = resultArea.getCaretPosition();
					
					try{
						
						int lineNumber  = resultArea.getLineOfOffset(caretPosition);
						int startOffset = resultArea.getLineStartOffset(lineNumber);
						number2 = Double.parseDouble(resultArea.getText().substring(startOffset));
						
						if(actionToPerform == "+"){
							
							subTotal = number1+number2;
							number1 = subTotal;						
							resultArea.append("+\n"+subTotal);
							
							
						}else if(actionToPerform == "-"){
							
							subTotal = number1-number2;
							number1 = subTotal;						
							resultArea.append("-\n"+subTotal);
							
							
						}else if(actionToPerform == "/"){
							
							subTotal = number1/number2;
							number1 = subTotal;						
							resultArea.append("/\n"+subTotal);
							
						}else if(actionToPerform == "*"){
							
							subTotal = number1*number2;
							number1 = subTotal;						
							resultArea.append("*\n"+subTotal);
							
						}
						
					}
					
					catch(BadLocationException e9){
						
						e9.printStackTrace();
					}
					
					initValue = 2;
					pointsPressed = 0;
					performAction =false;
					
					
				}
				
				actionToPerform = "*";				
			}else if(e.getSource() == enter){
				
				if(currentLine > 1){
					
					int caretPosition = resultArea.getCaretPosition();
					
					try{
						
						int lineNumber = resultArea.getLineOfOffset(caretPosition);
						int startOffset = resultArea.getLineStartOffset(lineNumber);
						
						if(number1 != 0){
						
							number2 =Double.parseDouble(resultArea.getText().substring(startOffset));
						
						}
						
						if(actionToPerform == "+"){
							
							resultArea.setText(Double.toString(number1+number2));
							
						}else if(actionToPerform == "-"){
							
							resultArea.setText(Double.toString(number1-number2));
							
							
						}else if(actionToPerform == "/"){
							
							resultArea.setText(Double.toString(number1/number2));
							
						}else if(actionToPerform == "*"){
							
							resultArea.setText(Double.toString(number1*number2));
							
						}
					}
					
					catch(BadLocationException e5){

						e5.printStackTrace();
					}
					
					
					initValue = 0;
					currentLine =1;
					number1 =0;
					number2=0;
					total = 0;
					subTotal =0;
					pointsPressed = 0;
					actionToPerform = "";
					performAction = false;					
				}
				
			}
			
		};
		
		
	};
	
	
	private class ListenForKeys implements KeyListener{
				
			public void keyPressed(KeyEvent e){
							
				 Pattern numEntered = Pattern.compile("[0-9]{1}");
				 Matcher numMatched = numEntered.matcher(Character.toString(e.getKeyChar()));
							
				if(numMatched.find()){
					 					
					if(initValue == 0){
						
						resultArea.setText(Character.toString(e.getKeyChar()));
						initValue = 1;
						//performAction = true;
					
					}else if(initValue == 2){
						
						int caretPosition = resultArea.getCaretPosition();
						
						try{
							
							int lineNumber = resultArea.getLineOfOffset(caretPosition);
							int startOffset = resultArea.getLineStartOffset(lineNumber);
							int endOffset = resultArea.getLineEndOffset(lineNumber);
												
						if(number1 != 0){
						
							resultArea.replaceRange(Character.toString(e.getKeyChar()), startOffset, endOffset);
							performAction = true;
						}else if(number1 == 0 && currentLine == 2){
							
							resultArea.setText(Character.toString(e.getKeyChar()));							
							currentLine = 1;
							performAction = false;
							
						}
														
							
							initValue = 1;
							
							
						}
						
						catch(BadLocationException e4){}
					
					}else{
						
						resultArea.append(Character.toString(e.getKeyChar()));
						performAction = true;
						
					}
					
					
				}else if(e.getKeyCode() == 110){
					
					if(pointsPressed == 0 && initValue <= 1){
						
						resultArea.append(Character.toString(e.getKeyChar()));
						
												
					}else if(pointsPressed == 0 && initValue == 2){
						
						
						if(number1 != 0){
							
							int caretPosition = resultArea.getCaretPosition();
							
							try{
								
								int lineNumber = resultArea.getLineOfOffset(caretPosition);
								int startOffset = resultArea.getLineStartOffset(lineNumber);
								int endOffset = resultArea.getLineEndOffset(lineNumber);
								resultArea.replaceRange("0"+Character.toString(e.getKeyChar()),startOffset,endOffset);
							
							}
							
							catch(BadLocationException e5){}
						
						}else if(number1 == 0 &&  currentLine == 2){

							System.out.println("here");	
							resultArea.setText("0"+Character.toString(e.getKeyChar()));
														
						}
						
					}
					
					initValue = 1;
					pointsPressed++;
				}else if(e.getKeyCode() == 107){
				
					if(currentLine == 1){
						
						number1 = Double.parseDouble(resultArea.getText());
						resultArea.append("+\n"+number1);
										
					}else if(performAction){
						
						int caretPosition = resultArea.getCaretPosition();
						
						try{
						
							int lineNumber = resultArea.getLineOfOffset(caretPosition);
							int startOffset = resultArea.getLineStartOffset(lineNumber);
							
							number2 = Double.parseDouble(resultArea.getText().substring(startOffset));
															
							if(actionToPerform == "+"){
								
								subTotal = number1+number2;
								System.out.println(number1+number2);
								number1 = subTotal;						
								resultArea.append("+\n"+subTotal);
								
								
							}else if(actionToPerform == "-"){
								
								subTotal = number1-number2;
								number1 = subTotal;						
								resultArea.append("-\n"+subTotal);
								
								
							}else if(actionToPerform == "/"){
								
								subTotal = number1/number2;
								number1 = subTotal;						
								resultArea.append("/\n"+subTotal);
								
							}else if(actionToPerform == "*"){
								
								subTotal = number1*number2;
								number1 = subTotal;						
								resultArea.append("*\n"+subTotal);
								
							}
						}
						
						catch(BadLocationException e3){}						
					};
				
					pointsPressed = 0;
					initValue = 2;
					performAction =false;
					currentLine++;
					actionToPerform = "+";
				}else if(e.getKeyCode() == 109){
					//-
					if(currentLine == 1){
						
						number1 = Double.parseDouble(resultArea.getText());
						resultArea.append("-\n"+number1);
										
					}else if(performAction){
						
						int caretPosition = resultArea.getCaretPosition();
						
						try{
						
							int lineNumber = resultArea.getLineOfOffset(caretPosition);
							int startOffset = resultArea.getLineStartOffset(lineNumber);
							
							number2 = Double.parseDouble(resultArea.getText().substring(startOffset));
															
							if(actionToPerform == "+"){
								
								subTotal = number1+number2;
								number1 = subTotal;						
								resultArea.append("+\n"+subTotal);
								
								
							}else if(actionToPerform == "-"){
								
								subTotal = number1-number2;
								number1 = subTotal;						
								resultArea.append("-\n"+subTotal);
								
								
							}else if(actionToPerform == "/"){
								
								subTotal = number1/number2;
								number1 = subTotal;						
								resultArea.append("/\n"+subTotal);
								
							}else if(actionToPerform == "*"){
								
								subTotal = number1*number2;
								number1 = subTotal;						
								resultArea.append("*\n"+subTotal);
								
							}
						}
						
						catch(BadLocationException e3){}						
						
					};
				
					pointsPressed = 0;
					initValue = 2;
					performAction =false;
					currentLine++;
					actionToPerform = "-";					
				}else if(e.getKeyCode() == 106){
					//*
					if(currentLine == 1){
						
						number1 = Double.parseDouble(resultArea.getText());
						resultArea.append("*\n"+number1);
										
					}else if(performAction){
						
						int caretPosition = resultArea.getCaretPosition();
						
						try{
						
							int lineNumber = resultArea.getLineOfOffset(caretPosition);
							int startOffset = resultArea.getLineStartOffset(lineNumber);
							
							number2 = Double.parseDouble(resultArea.getText().substring(startOffset));
															
							if(actionToPerform == "+"){
								
								subTotal = number1+number2;
								number1 = subTotal;						
								resultArea.append("+\n"+subTotal);
								
								
							}else if(actionToPerform == "-"){
								
								subTotal = number1-number2;
								number1 = subTotal;						
								resultArea.append("-\n"+subTotal);
								
								
							}else if(actionToPerform == "/"){
								
								subTotal = number1/number2;
								number1 = subTotal;						
								resultArea.append("/\n"+subTotal);
								
							}else if(actionToPerform == "*"){
								
								subTotal = number1*number2;
								number1 = subTotal;						
								resultArea.append("*\n"+subTotal);
								
							}
						}
						
						catch(BadLocationException e3){}						
						
					};
				
					pointsPressed = 0;
					initValue = 2;
					performAction =false;
					currentLine++;
					actionToPerform = "*";					
				}else if(e.getKeyCode() == 111){
					///
				if(currentLine == 1){
					
					number1 = Double.parseDouble(resultArea.getText());
					resultArea.append("\\\n"+number1);
									
				}else if(performAction){
					
					int caretPosition = resultArea.getCaretPosition();
					
					try{
					
						int lineNumber = resultArea.getLineOfOffset(caretPosition);
						int startOffset = resultArea.getLineStartOffset(lineNumber);
						
						number2 = Double.parseDouble(resultArea.getText().substring(startOffset));
														
						if(actionToPerform == "+"){
							
							subTotal = number1+number2;
							number1 = subTotal;						
							resultArea.append("/\n"+subTotal);
							
							
						}else if(actionToPerform == "-"){
							
							subTotal = number1-number2;
							number1 = subTotal;						
							resultArea.append("-\n"+subTotal);
							
							
						}else if(actionToPerform == "/"){
							
							subTotal = number1/number2;
							number1 = subTotal;						
							resultArea.append("/\n"+subTotal);
							
						}else if(actionToPerform == "*"){
							
							subTotal = number1*number2;
							number1 = subTotal;						
							resultArea.append("*\n"+subTotal);
							
						}
					}
					
					catch(BadLocationException e3){}						
					
				};
			
				pointsPressed = 0;
				initValue = 2;
				performAction =false;
				currentLine++;
				actionToPerform = "/";
				
				}else if(e.getKeyCode() == 10 || e.getKeyCode() == 61){
					
					//=
					
					if(currentLine > 1){
						
						int caretPosition = resultArea.getCaretPosition();
						
						try{
							
							int lineNumber = resultArea.getLineOfOffset(caretPosition);
							int startOffset = resultArea.getLineStartOffset(lineNumber);
							
							number2 = Double.parseDouble(resultArea.getText().substring(startOffset));
							
							if(actionToPerform == "+"){
								resultArea.setText(Double.toString(number1+number2));
							}else if(actionToPerform == "-"){
								resultArea.setText(Double.toString(number1-number2));
							}else if(actionToPerform == "*"){
								resultArea.setText(Double.toString(number1*number2));
							}else if(actionToPerform == "/"){
								resultArea.setText(Double.toString(number1/number2));
							}
							
						}
						
						catch(BadLocationException e4){	}
						
						initValue = 0;
						currentLine =1;
						number1 =0;
						number2=0;
						total = 0;
						subTotal =0;
						pointsPressed= 0;
						actionToPerform = "";
						performAction = false;
					}
				
				}else if(e.getKeyCode() == 27){
				
					
					initValue = 0;
					currentLine =1;
					number1 =0;
					number2=0;
					total = 0;
					subTotal =0;
					actionToPerform = "";
					performAction = false;
					pointsPressed = 0;
					resultArea.setText("0");
													
						
				}	
				
					
			};
		
			public void keyReleased(KeyEvent e){
			
		
			}
			
			public void keyTyped(KeyEvent e){
		
				 	
				
			}
			
	}	
}