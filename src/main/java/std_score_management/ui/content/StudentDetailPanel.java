package std_score_management.ui.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;

import std_score_management.dto.Student;
import std_score_management.dto.StudentDetail;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;

@SuppressWarnings("serial")
public class StudentDetailPanel extends AbstractContentPanel<StudentDetail> implements ActionListener {
	private JLabel lblPic;
	private JButton btnAddPic;
	private JTextField tfStdNo;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JDateChooser dateEnter;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator;
	private JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));

	public StudentDetailPanel() {
		initialize();
		loadPic(null);
	}
	
	private void loadPic(String imgFilePath) {
		Image changeImage = null;
		if (imgFilePath == null) {
			ImageIcon icon = new ImageIcon(imgPath + "noImage.png");
			changeImage = icon.getImage().getScaledInstance(120, 150, Image.SCALE_SMOOTH);
		} else {
			ImageIcon icon = new ImageIcon(imgFilePath);
			changeImage = icon.getImage().getScaledInstance(120, 150, Image.SCALE_SMOOTH);
		}
		ImageIcon changeIcon = new ImageIcon(changeImage);
		lblPic.setIcon(changeIcon);
	}

	public void setTfStdNo(Student student) {
		tfStdNo.setText(String.valueOf(student.getStdNo()));
	}

	private void initialize() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "학생 상세 정보", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		
		JPanel pWest = new JPanel();
		add(pWest, BorderLayout.WEST);
		
		JPanel pPic = new JPanel();
		pWest.add(pPic);
		pPic.setLayout(new BorderLayout(0, 10));
		
		lblPic = new JLabel("");
		lblPic.setHorizontalAlignment(SwingConstants.CENTER);
		lblPic.setPreferredSize(new Dimension(120, 150));
		pPic.add(lblPic, BorderLayout.NORTH);
		
		btnAddPic = new JButton("사진 추가");
		btnAddPic.addActionListener(this);
		pPic.add(btnAddPic, BorderLayout.SOUTH);
		
		JPanel pCenter = new JPanel();
		add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		pCenter.add(panel);
		panel.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblStdNo = new JLabel("학번");
		lblStdNo.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblStdNo);
		
		tfStdNo = new JTextField();
		tfStdNo.setEditable(false);
		panel.add(tfStdNo);
		tfStdNo.setColumns(10);
		
		JLabel lblEnterDate = new JLabel("입학일");
		lblEnterDate.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblEnterDate);
		
		dateEnter = new JDateChooser(new Date());
		panel.add(dateEnter);
		
		JLabel lblGender = new JLabel("성별");
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblGender);
		
		JPanel pGender = new JPanel();
		panel.add(pGender);
		pGender.setLayout(new BoxLayout(pGender, BoxLayout.X_AXIS));
		
		rdbtnMale = new JRadioButton("남성");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setSelected(true);
		pGender.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("여성");
		buttonGroup.add(rdbtnFemale);
		pGender.add(rdbtnFemale);
	}

	@Override
	public void setItem(StudentDetail item) {
		tfStdNo.setText(String.valueOf(item.getStdNo()));
		byte[] iconBytes = item.getStdPhoto();
		ImageIcon icon = new ImageIcon(iconBytes);
		Image changeImage = icon.getImage().getScaledInstance(120, 150, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImage);
		lblPic.setIcon(changeIcon);
		
		dateEnter.setDate(item.getEnterDate());
		if(item.isGender() == true) {
			rdbtnMale.setSelected(true);
		} else {
			rdbtnFemale.setSelected(true);
		}
	}

	@Override
	public StudentDetail getItem() {
		validCheck();
		int stdNo = Integer.parseInt(tfStdNo.getText().trim());
		boolean gender = rdbtnMale.isSelected()? true : false;
		Date enterDate = dateEnter.getDate();
		byte[] stdPhoto = getImage();
		
		return new StudentDetail(stdNo, gender, enterDate, stdPhoto);
	}

	private byte[] getImage() {
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()){
			ImageIcon icon = (ImageIcon) lblPic.getIcon();
			BufferedImage bi = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
			
			Graphics2D g2 = bi.createGraphics();
			g2.drawImage(icon.getImage(), 0, 0, null);
			g2.dispose();
			
			ImageIO.write(bi, "png", baos);
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void validCheck() {
		
	}

	@Override
	public void clearTf() {
		loadPic(null);
		dateEnter.setDate(new Date());
		rdbtnMale.setSelected(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAddPic) {
			actionPerformedBtnAddPic(e);
		}
	}
	
	protected void actionPerformedBtnAddPic(ActionEvent e) {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg & png & gif images", "jpg", "png", "gif");
		chooser.setFileFilter(filter);
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		int res = chooser.showOpenDialog(null);
		if (res != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		String chooserFilePath = chooser.getSelectedFile().getPath();
		loadPic(chooserFilePath);
	}
}
