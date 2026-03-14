import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hwss0603 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] list = {};
        while (true) {
            System.out.println("******************** QUẢN LÝ BIỂN SỐ XE ********************");
            System.out.println("1. Thêm các biển số xe");
            System.out.println("2. Hiển thị danh sách biển số xe");
            System.out.println("3. Tìm kiếm biển số xe");
            System.out.println("4. Tìm kiếm biển số xe theo mã tỉnh");
            System.out.println("5. Sắp xếp biển số xe tăng dần");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int n = Integer.parseInt(sc.nextLine());
            switch(n) {
                case 1:
                    System.out.print("Nhập biển số xe cần thêm: ");
                    String s = sc.nextLine();
                    Pattern p;
                    Matcher m;
                    p = Pattern.compile("^[0-9]{2}[A-Z]{2}-[0-9]{3}.[0-9]{2}$");
                    m = p.matcher(s);
                    if (m.find()) {
                        String[] list1 = new String[list.length+1];
                        System.arraycopy(list, 0, list1, 0, list.length);
                        list1[list1.length-1] = s;
                        list = list1;
                    }
                    else {
                        System.out.println("Biển số xe đang bị sai định dạng!");
                    }
                    break;
                case 2:
                    if (list.length > 0) {
                        System.out.println("Danh sách các biển số xe:");
                        for (int i = 0; i < list.length; i++) {
                            System.out.println("Biển xe thứ " + (i + 1) + ": " + list[i]);
                        }
                    }
                    else {
                        System.out.println("Chưa tồn tại biển số xe nào trong danh sách!");
                    }
                    break;
                case 3:
                    System.out.println("Nhập biển số xe cần tìm: ");
                    String findStr = sc.nextLine();
                    if (Arrays.asList(list).contains(findStr)) {
                        System.out.println("Đã tìm thấy biển số xe cần tìm!");
                    }
                    else {
                        System.out.println("Không tồn tại biển số xe cần tìm!");
                    }
                    break;
                case 4:
                    System.out.println("Nhập mã tỉnh cần tìm: ");
                    String findM = sc.nextLine();
                    String[] res4 = {};
                    for (String string : list) {
                        if (string.substring(0, 2).equals(findM.replaceAll("\\s+", " ").substring(0, 2))) {
                            String[] res41 = new String[res4.length + 1];
                            System.arraycopy(res4, 0, res41, 0, res4.length);
                            res41[res41.length - 1] = string;
                            res4 = res41;
                        }
                    }
                    if (res4.length > 0) {
                        System.out.println("Danh sách biển số xe cần tìm theo tỉnh có mã "+findM.replaceAll("\\s+", " ").substring(0, 2)+":");
                        for (String stres4 : res4) {
                            System.out.println("- " + stres4);
                        }
                    }
                    else {
                        System.out.println("Không tồn tại biển số xe nào cần tìm!");
                    }
                    break;
                case 5:
                    Arrays.sort(list);
                    System.out.println("Đã sắp xếp các biển số xe theo chiều tăng dần!");
                    break;
                case 6:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);
                default:
                    System.out.println("Vui lòng chọn đúng trong danh sách trên!");
            }
        }
    }
}
