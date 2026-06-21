package EVENTDRIVEN;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import oop.Event;

public class EventGui4 {

	private Event[] events = new Event[100];
	private int count = 0;

	public void start() {

		JFrame frame = new JFrame(" THIS IS THE EVENT REGISTRATION SYSTEM");
		frame.setSize(550, 450);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel titlelabel = new JLabel("EVENT SYSTEM");
		titlelabel.setBounds(190, 10, 150, 25);
		frame.add(titlelabel);

		JLabel passwordlabel = new JLabel("ENTER YOUR PASSWORD");
		passwordlabel.setBounds(20, 40, 100, 25);
		frame.add(passwordlabel);

		JPasswordField passwordbox = new JPasswordField();
		passwordbox.setBounds(120, 40, 100, 25);
		frame.add(passwordbox);

		JLabel inconstantmessage = new JLabel();
		inconstantmessage.setBounds(20, 70, 450, 25);
		frame.add(inconstantmessage);

		JButton addevent = new JButton("ADD YOUR EVENT");
		addevent.setBounds(20, 120, 200, 30);
		frame.add(addevent);

		JButton eventlisting = new JButton("LIST YOUR EVENTS");
		eventlisting.setBounds(240, 120, 200, 30);
		frame.add(eventlisting);

		JButton addparticipants = new JButton("REGISTER HERE");
		addparticipants.setBounds(20, 170, 200, 30);
		frame.add(addparticipants);

		JButton sortevents = new JButton("SORT EVENTS BY DATE");
		sortevents.setBounds(240, 170, 200, 30);
		frame.add(sortevents);

		JButton exit = new JButton("EXIT");
		exit.setBounds(140, 250, 200, 30);
		frame.add(exit);

		// should disable all buttums until pass entered correct
		addevent.setEnabled(false);
		eventlisting.setEnabled(false);
		addparticipants.setEnabled(false);
		sortevents.setEnabled(false);
		exit.setEnabled(false);

		passwordbox.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {// gets the pass and check if correct for enter key
					String usedPass = new String(passwordbox.getPassword());
					if (usedPass.equals("1234")) {
						inconstantmessage.setText("access guaranteed");

						addevent.setEnabled(true);
						eventlisting.setEnabled(true);
						addparticipants.setEnabled(true);
						sortevents.setEnabled(true);
						exit.setEnabled(true);

					} else {
						inconstantmessage.setText("access rejected......check password");
						passwordbox.setText("");// to clear the box
					}
				}

			}
		});

		addevent.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				inconstantmessage.setText("use this buttun to add events");
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					String name = JOptionPane.showInputDialog(frame, "ENETER THE EVENT NAME");
					if (name == null || name.isEmpty()) {
						return;
					}

					String ids = JOptionPane.showInputDialog(frame, "ENTER EVENT ID");
					int id = Integer.parseInt(ids);// convert the id to integer value

					String dates = JOptionPane.showInputDialog(frame, "ENTER EVENT DATE");
					int date = Integer.parseInt(dates);

					String venue = JOptionPane.showInputDialog(frame, "ENTER EVENT VENUE");

					String capacitys = JOptionPane.showInputDialog(frame, "ENTER EVENT CAPACITY");
					int capacity = Integer.parseInt(capacitys);

					events[count] = new Event(id, date, capacity, name, venue);
					count++;
					inconstantmessage.setText("successfully added");
					JOptionPane.showMessageDialog(frame, "EVENT :" + name + " ADDED");
				} catch (Exception m) {
					JOptionPane.showMessageDialog(frame, "wrong input");
				}
			}
		});

		eventlisting.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				inconstantmessage.setText("use this buttum to list events");
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (count == 0) {
					JOptionPane.showMessageDialog(frame, "NO EVENT FOUND");
				} else {
					for (int i = 0; i < count; i++) {
						System.out.println("ID: " + events[i].getIdv() + " | Name: " + events[i].getNamev()
								+ " | Date: " + events[i].getDatev() + " CAPACITY: " + events[i].getCapacityv()
								+ " VENUE: " + events[i].getVenuev());
					}
					JOptionPane.showMessageDialog(frame, "THE LISTED EVENTS IN THE CONSOLE");
				}

			}
		});

		addparticipants.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				inconstantmessage.setText("use this buttum to add participants");
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				String inputs = JOptionPane.showInputDialog(frame, "ENTER EVENT IS TO ADD TO IT");
				if (inputs != null && !inputs.isEmpty()) {// check if the user press cancel or did not type anything
					int searchids = Integer.parseInt(inputs);
					boolean found = false;
					for (int i = 0; i < count; i++) {
						if (events[i].getIdv() == searchids) {
							found = true;

							if (events[i].registerOne()) {
								inconstantmessage.setText("participants added to event id :" + searchids);
								JOptionPane.showMessageDialog(frame, "registered successfully ");
							} else {
								JOptionPane.showMessageDialog(frame, "event is fully booked");
							}
						}
					}
					if (!found) {
						JOptionPane.showMessageDialog(frame, "EVENTS YOU ARE TRYING TO ACCESS IS NOT FOUND");
					}

				}

			}
		});

		sortevents.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				inconstantmessage.setText("use this buttum to sort events");
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(count > 1) {
				for (int i = 0; i < count - 1; i++) {
					for (int j = 0; j < count - 1; j++) {
						if (events[j].getDatev() > events[j + 1].getDatev()) {
							Event temp = events[j];
							events[j] = events[j + 1];
							events[j + 1] = temp;
						}
					}
				}
				for (int i = 0; i < count; i++) {
					System.out.println("ID: " + events[i].getIdv() + " | Name: " + events[i].getNamev() + " | Date: "
							+ events[i].getDatev());
				}
				inconstantmessage.setText("sorting events by date");
				JOptionPane.showMessageDialog(frame, "events have been sorted");
			}
				else {
					JOptionPane.showMessageDialog(frame, "no events to sort");
				}
			}
		});

		exit.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				inconstantmessage.setText("use this buttum to exit the system");
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(frame, "THANKS FOR USING THE SYSTEM");
				frame.dispose();
			}
		});

		addparticipants.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				inconstantmessage.setText("move your mouse to complete the procces");
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				inconstantmessage.setBounds(e.getX(), e.getY() + 150, 300, 25);
			}
		});
		frame.setVisible(true);
	}

}
