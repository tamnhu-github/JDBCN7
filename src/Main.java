import java.sql.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		List<LopHoc> list = LopHoc.getList();
		for (LopHoc item: list) {
			System.out.println(item.toString());
		}
		System.out.println('\n');
//		String a = "Creat Name";
//		LopHoc.create(a);
//		list = LopHoc.getList();
//		for (LopHoc item: list) {
//			System.out.println(item.toString());
//		}
//		System.out.println('\n');
//		LopHoc.update(18,"Update Name");
//		list = LopHoc.getList();
//		for (LopHoc item: list) {
//			System.out.println(item.toString());
//		}
		LopHoc.delete("Nhu");
		list = LopHoc.getList();
		for (LopHoc item: list) {
			System.out.println(item.toString());
		}
	}
}
