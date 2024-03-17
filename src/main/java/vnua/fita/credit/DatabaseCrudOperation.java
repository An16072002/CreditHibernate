package vnua.fita.credit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;




public class DatabaseCrudOperation {
    private static String jdbcURL = "jdbc:ucanaccess://lib/QLSV.accdb";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "";

    // Phương thức trả về một kết nối
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    //Phuong thuc dua ra tat ca sinh vien
    public static void selectAllUsers() {
		String SELECT_ALL_USERS_SQL = "SELECT * FROM SINHVIEN";
        try (Connection connection = getConnection();
            Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery(SELECT_ALL_USERS_SQL);

            // Duyệt danh sach bản ghi trả về
            while (rs.next()) {
                String username = rs.getString("MaSV");
                String password = rs.getString("HoDem");
                System.out.println(username + "," + password);
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        }
	}
    
//
    // Phương thức thêm mới User
 	public static void insertStudent(Integer MaSV, String HoDem) {
 		String INSERT_USERS_SQL = "INSERT INTO SINHVIEN (MaSV, HoDem) VALUES (?,?)";
         // Bước 1: Thiết lập kết nối
         try (Connection connection = getConnection();
             // Bước 2: Tạo câu truy vấn
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
             
         	 preparedStatement.setInt(1, MaSV);
             preparedStatement.setString(2, HoDem);

             System.out.println(preparedStatement);
             // Bước 3: Thực thi câu truy vấn
             int rowsInserted = preparedStatement.executeUpdate();
             if (rowsInserted > 0) {
                 System.out.println("Thêm mới thành công!");
             }else {
             	System.out.println("Thêm mới không thành công!");
             }
         } catch (SQLException e) {
         	e.printStackTrace();
         }
 	}

 	//them msv ma mh vao bang ket qua
 	public static void insertKetQua(String MaSV, String MaMH) {
 		String INSERT_USERS_SQL = "INSERT INTO KETQUA (Masv, MaMH) VALUES (?,?)";
         // Bước 1: Thiết lập kết nối
         try (Connection connection = getConnection();
             // Bước 2: Tạo câu truy vấn
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
             
         	 preparedStatement.setString(1, MaSV);
             preparedStatement.setString(2, MaMH);

             System.out.println(preparedStatement);
             // Bước 3: Thực thi câu truy vấn
             int rowsInserted = preparedStatement.executeUpdate();
             if (rowsInserted > 0) {
                 System.out.println("Thêm mới thành công!");
             }else {
             	System.out.println("Thêm mới không thành công!");
             }
         } catch (SQLException e) {
         	e.printStackTrace();
         }
 	}
 	// Phương thức kiểm tra sự tồn tai cua sinh vien trong bang ket qua
 	public static boolean checkUser(String Masv, String MaMH) throws SQLException{
 		String SELECT_USERS_SQL = "SELECT * from KETQUA WHERE Masv = ? and MaMH = ?";
 		
     	try (
     		Connection connection = getConnection();
     		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_SQL))  {
         	preparedStatement.setString(1, Masv);
         	preparedStatement.setString(2, MaMH);

         	System.out.println(preparedStatement);
         	ResultSet resultSet = preparedStatement.executeQuery();
         return resultSet.next();
     	}
 	}
 	
 	//// Phương thức cap nhap diem
	public static void changeDiem(String Masv, String MaMH,int Diem) {
		   String UPDATE_USERS_SQL = "UPDATE KETQUA SET Diem = ? WHERE Masv = ? AND MaMH = ? ";
	        try (Connection connection = getConnection();

	            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {
	        	preparedStatement.setInt(1, Diem);
	        	preparedStatement.setString(2, Masv);
	            preparedStatement.setString(3, MaMH);
	           

	            System.out.println(preparedStatement);
	            int rowsUpdated = preparedStatement.executeUpdate();
	            if (rowsUpdated > 0) {
	                System.out.println("Cap nhap diem thanh cong");
	            }else {
	            	System.out.println("Cap nhap diem khong thanh cong");
	            }
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
	}
	
	// Hàm hiển thị thông tin chi tiết và môn học của sinh viên
	private static void hienThiThongTin( String maSV) throws SQLException {
	        // Truy vấn thông tin sinh viên từ bảng Sinhvien
	        String querySV = "SELECT * FROM Sinhvien WHERE maSV=?";
	        try (
	        	Connection connection = getConnection();
	        	PreparedStatement preparedStatementSV = connection.prepareStatement(querySV)) {
	            preparedStatementSV.setString(1, maSV);
	            ResultSet resultSetSV = preparedStatementSV.executeQuery();

	            if (resultSetSV.next()) {
	                // Hiển thị thông tin sinh viên từ bảng Sinhvien
	                System.out.println("Thông tin sinh viên:");
	                System.out.println("Mã sinh viên: " + resultSetSV.getString("MaSV"));
	                System.out.println("Họ đệm: " + resultSetSV.getString("HoDem"));
	                System.out.println("Tên: " + resultSetSV.getString("Ten"));
	                System.out.println("Ngày Sinh: " + resultSetSV.getString("Ngaysinh"));
	                System.out.println("Gioi tính: " + resultSetSV.getString("Gioitinh"));
	                System.out.println("Ma lớp: " + resultSetSV.getString("Malop"));
	                // Truy vấn môn học và điểm của sinh viên từ bảng KETQUA
	                String queryDiem = "SELECT * FROM KETQUA WHERE maSV=?";
	                try (
	                	Connection connection1 = getConnection();
	                	PreparedStatement preparedStatementDiem = connection1.prepareStatement(queryDiem)) {
	                    preparedStatementDiem.setString(1, maSV);
	                    ResultSet resultSetDiem = preparedStatementDiem.executeQuery();

	                    // Hiển thị các môn học và điểm
	                    System.out.println("\nCác môn học và điểm:");
	                    while (resultSetDiem.next()) {
	                        System.out.println("Mã môn học: " + resultSetDiem.getString("MaMH"));
	                        System.out.println("Điểm: " + resultSetDiem.getInt("Diem"));
	                        System.out.println("----------------------");
	                    }
	                }
	            } else {
	                System.out.println("Sinh viên không tồn tại!");
	            }
	        }
	 }
	
	private static void hienThiThongTin2( String maSV) throws SQLException {
        // Thực hiện INNER JOIN giữa bảng Sinhvien và KETQUA
		 String query = "SELECT Sinhvien.MaSV, Sinhvien.HoDem, Sinhvien.Ten,Sinhvien.Ngaysinh,Sinhvien.Gioitinh,Sinhvien.Malop,KETQUA.MaMH, KETQUA.Diem " +
                 "FROM Sinhvien " +
                 "INNER JOIN KETQUA ON Sinhvien.maSV = KETQUA.maSV " +
                 "WHERE Sinhvien.maSV = ?";
        try (
        		// Kết nối đến CSDL
        	Connection connection = getConnection();
        		
        	PreparedStatement preparedStatementSV = connection.prepareStatement(query)) {
            preparedStatementSV.setString(1, maSV);
            ResultSet resultSet = preparedStatementSV.executeQuery();
        
            String kt = "";
         // Hiển thị kết quả INNER JOIN
            while (resultSet.next()) {
            	String check=resultSet.getString("MaSV");
            	if(!check.equals(kt)) {
            		System.out.println("Thông tin sinh viên:");
                    System.out.println("Mã sinh viên: " + resultSet.getString("MaSV"));
                    System.out.println("Họ đệm: " + resultSet.getString("HoDem"));
                    System.out.println("Tên: " + resultSet.getString("Ten"));
                    System.out.println("Ngày Sinh: " + resultSet.getString("Ngaysinh"));
                    System.out.println("Gioi tính: " + resultSet.getString("Gioitinh"));
                    System.out.println("Ma lớp: " + resultSet.getString("Malop"));
                    System.out.println("----------------------");
                    kt = check;
            	}
                System.out.println("Mã môn học: " + resultSet.getString("MaMH"));
                System.out.println("Điểm: " + resultSet.getInt("Diem"));
                System.out.println("----------------------");
                
            }
        }
 }

	public Student getStudent(String maSV) throws SQLException {
		   Student student = null;
		 // Thực hiện INNER JOIN giữa bảng Sinhvien, KETQUA và MonHoc
        String query = "SELECT SINHVIEN.MaSV, SINHVIEN.Ten, Sinhvien.DiaChi,SINHVIEN.Malop" +
                       "KETQUA.MaMH, MONHOC.KyHoc, MONHOC.TenMH, KETQUA.Diem " +
                       "FROM Sinhvien " +
                       "INNER JOIN KETQUA ON SINHVIEN.MaSV = KETQUA.MaSV " +
                       "INNER JOIN MONHOC ON KETQUA.MaMH = MONHOC.MaMH " +
                       "WHERE SINHVIEN.MaSV = ?";	
		
        try (
	        	Connection connection = getConnection();
	        	PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, maSV);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            

	            while (resultSet.next()) {
	            	if (student == null) {
                        // Nếu chưa có thông tin sinh viên, khởi tạo đối tượng Student
                        student = new Student(
                                resultSet.getString("code"),
                                resultSet.getString("fullname"),
                                resultSet.getString("address"),
                                resultSet.getString("class_")
                        );
                    }
                        // Lấy thông tin từ ResultSet
                        String termCode = resultSet.getString("KyHoc");
                        String subjectCode = resultSet.getString("MaMH");
                        String subjectName = resultSet.getString("TenMH");
                        Integer mark = resultSet.getInt("Diem");
                        if (!student.getTermList().containsKey(termCode)) {
                            // Nếu chưa có, thêm một term mới vào termList
                            student.addTerm(new Term(termCode));
                        }

                        // Thêm môn học vào term
                        student.addSubject(termCode, new Subject(subjectCode, subjectName, mark));
                        
                    }
	            
	        }catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		return student;
	}
	
	//ca kho
	public List<Student> getAllStudent(){
		return null;
		//Cá khó nên em không làm dc
	}
	
 	public static void deleteUser(String Ten) {
 	   String DELETE_USERS_SQL = "DELETE FROM SINHVIEN WHERE  Ten= ?";
         try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL)) {
             preparedStatement.setString(1, Ten);

             System.out.println(preparedStatement);
             int rowsDeleted = preparedStatement.executeUpdate();
             if (rowsDeleted > 0) {
                 System.out.println("Xóa thành công!");
             }else {
             	System.out.println("Xóa không thành công!");
             }
         } catch (SQLException e) {
         	e.printStackTrace();
         }
 	}

   //Contructor
    public DatabaseCrudOperation(String jdbcURL,String jdbcUsername,String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUsername=jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
		//cho sv nhap va ma sv va ma mh
    	 Scanner sc = new Scanner(System.in);
    	/*
    	System.out.println("Nhap va msv va ma mh can them\n");
    	 Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao ma sv: \n");
		String maSV = sc.nextLine();
		
		System.out.println("Nhap vao ma mh: \n");
		String maMH = sc.nextLine();
		
		insertKetQua(maSV,maMH);
		*/
    	 
    	 /*
    	System.out.println("Nhap va msv va ma mh can them de cap nhap diem \n");
    	System.out.println("Nhap vao ma sv: \n");
		String maSV = sc.nextLine();
		
		System.out.println("Nhap vao ma mh: \n");
		String maMH = sc.nextLine();
		
    	boolean a = checkUser(maSV, maMH) ;
    	if(a) {
    		System.out.println("Nhap vao diem mh: \n");
    		 int Diem = sc.nextInt();
    		 changeDiem(maSV,maMH,Diem);
    	}else {
    		System.out.println("Nhap sai khong tồn tại");
    	}
    	*/
		
	hienThiThongTin2("651514");
	
	
	}

	
}
