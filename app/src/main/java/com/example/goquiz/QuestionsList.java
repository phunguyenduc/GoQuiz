package com.example.goquiz;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.goquiz.databinding.ActivityQuestionslistBinding;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionsList extends AppCompatActivity {
    private ActivityQuestionslistBinding binding;
    private List<QuestionClass> questionList;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestionslistBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        QuestionAdapter adapter = new QuestionAdapter(questionList);
        binding.QuestionsListView.setAdapter(adapter);
        binding.QuestionsListView.setOnItemClickListener((parent, view1, i, id) -> {
            QuestionClass selected = questionList.get(i);
            Intent intent = new Intent(QuestionsList.this,QuestionDetailed.class);
            Log.d("QuestionList", "Selected question: " + selected.getQuestionText());
            intent.putExtra("cauhoi", selected.getQuestionText());
            intent.putExtra("dokho", selected.getDifficultyLevel());
            intent.putExtra("dapan", selected.getCorrectAnswerIndex());
            String[] tuychon = selected.getAnswerOptions().toArray(new String[0]);
            intent.putExtra("tuychon", tuychon);
            startActivity(intent);
        });

        String[] categories = getResources().getStringArray(R.array.categories);
        ((MaterialAutoCompleteTextView) binding.from.getEditText()).setSimpleItems(categories);
        //ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1)
    }
    public QuestionsList() {
        questionList = new ArrayList<>();
        questionList.add(new QuestionClass(1,"math", "Tính giá trị của biểu thức sau: 11 + 56", Arrays.asList("64", "65", "66", "67"), 4, 0));
        questionList.add(new QuestionClass(2,"math", "Hình tam giác có bao nhiêu cạnh?", Arrays.asList("3", "4", "5", "6"), 1, 0));
        questionList.add(new QuestionClass(3,"math", "Nếu A + B = 76 và A - B = 38 thì A : B = ?", Arrays.asList("3", "4", "5", "6"), 1, 0));
        questionList.add(new QuestionClass(4,"math", "Tính giá trị của biểu thức: tan(0)", Arrays.asList("0", "1", "-1", "∞"), 1, 0));
        questionList.add(new QuestionClass(5,"math", "Giải phương trình: 9x + 4 = 40", Arrays.asList("x = 4", "x = -4", "x = 3", "x = 2"), 1, 0));
        questionList.add(new QuestionClass(6,"math", "Năm ngày trước của ngày sau ngày mai là ngày thứ tư. Hỏi hôm qua là thứ mấy?", Arrays.asList("Thứ Tư", "Thứ Năm", "Thứ Sáu", "Chủ nhật"), 3, 1));
        questionList.add(new QuestionClass(7,"math", "Cho tam giác có cạnh a = 6 cm, cạnh b = 8 cm, cạnh c = 10 cm. Tam giác đó là tam giác gì?", Arrays.asList("Tam giác vuông", "Tam giác đều", "Tam giác cân", "Tam giác nhọn"), 1, 1));
        questionList.add(new QuestionClass(8,"math", "Gieo đồng tiền 5 lần cân đối và đồng chất. Xác suất để được ít nhất một lần xuất hiện mặt sấp?", Arrays.asList("31/32", "21/32", "11/23", "11/32"), 1, 1));
        questionList.add(new QuestionClass(9,"math", "Nếu 5 con gà ấp 5 quả trứng trong 5 ngày là xong. Vậy cần bao nhiêu ngày để 100 con gà ấp xong 100 quả trứng?", Arrays.asList("1 ngày", "3 ngày", "5 ngày", "15 ngày"), 3, 1));
        questionList.add(new QuestionClass(10,"math", "Số nào có khác với các số còn lại: 9, 16, 24, 49", Arrays.asList("9", "16", "24", "49"), 3, 1));

        questionList.add(new QuestionClass(11,"physic", "Mây ngũ sắc là sự xuất hiện của màu sắc trong một đám mây giống như vết dầu loang ta thấy trên mặt nước.Vậy đám mây ngũ sắc được tạo ra nhờ hiện tượng gì?", Arrays.asList("Nhiễu xạ", "Khúc xạ", "Tán sắc", "Đối lưu"), 1,0));
        questionList.add(new QuestionClass(12,"physic","Tai người có thể cảm thụ được những dao động có tần số nằm trong giới hạn nào?", Arrays.asList("10Hz đến 10kHz", "16Hz đến 10kHz", "10Hz đến 20kHz", "16Hz đến 20Khz"), 4, 0));
        questionList.add(new QuestionClass(13,"physic","Trong hạt nhân của nguyên tử, hạt nào có điện tích dương?",Arrays.asList("Electron", "Proton", "Photon", "Notron"),2,0));
        questionList.add(new QuestionClass(14,"physic","Đơn vị nào đo lường khả năng của một mạch dẫn điện chịu được dòng điện?",Arrays.asList("Volt","Ampe","Ohm","Watt"),3,0));
        questionList.add(new QuestionClass(15,"physic","Đơn vị nào đo lường áp suất?",Arrays.asList("Pascal","Newton","Joule","Watt"),1,0));
        questionList.add(new QuestionClass(16,"physic","Áp suất khí quyển giảm đi khi độ cao tăng lên. Điều này được mô tả bởi định luật nào?",Arrays.asList("Định luật Pascal","Định luật Archimedes","Định luật Boyle","Định luật Newton"),3,1));
        questionList.add(new QuestionClass(17,"physic","Điều gì xảy ra khi nước đun sôi ở nhiệt độ 100 độ C?",Arrays.asList("Chuyển từ chất lỏng thành chất khí","Chuyển từ chất lỏng thành chất rắn","Chuyển từ chất khí thành chất rắn","Chuyển từ chất lỏng thành chất khí "),4,1));
        questionList.add(new QuestionClass(18,"physic","Đâu là công thức Ohm?",Arrays.asList("V = IR^2","P = IV","R = V/I","I = V/R"),3,1));
        questionList.add(new QuestionClass(19,"physic","Ánh sáng trắng có thể phân chia thành các màu sắc như thế nào?",Arrays.asList("Giảm cường độ","Phản xạ","Quang phổ","Phản chiếu"),3,1));
        questionList.add(new QuestionClass(20,"physic","Ai là tác giả của câu nói nổi tiếng: Hãy cho tôi một điểm tựa, tôi sẽ nhấc bổng quả đất lên?",Arrays.asList("Albert Einstein","Archimedes","Nikola Tesla","Thomas Edison"),2,1));

        questionList.add(new QuestionClass(21,"chemis","Nguyên tố nào chiếm tỷ trọng lớn nhất trong không khí?",Arrays.asList("Nitơ","Oxi","Hidro","Metan"),1,0));
        questionList.add(new QuestionClass(22,"chemis","Công thức hóa học của nước là gì?",Arrays.asList("H20","HOH","CO2","NH3"),1,0));
        questionList.add(new QuestionClass(23,"chemis","Loại phản ứng hóa học nào xảy ra khi một nguyên tố kết hợp với một nguyên tố khác để tạo ra hợp chất mới?",Arrays.asList("Phân hủy","Phản ứng oxi hóa","Phản ứng trùng hợp","Phản ứng tổng hợp"),4,0));
        questionList.add(new QuestionClass(24,"chemis","Công thức hóa học của amoni là gì?",Arrays.asList("NH4","NH3","NO2","NO"),2,0));
        questionList.add(new QuestionClass(25,"chemis","Nguyên tố nào sao đây là khí hiếm?",Arrays.asList("F","N","Cl","He"),4,0));
        questionList.add(new QuestionClass(26,"chemis","Nguyên tố nào chiếm tỷ lệ cao nhất trong vỏ trái đất?",Arrays.asList("Sắt","Đồng","Silic","Nhôm"),3,1));
        questionList.add(new QuestionClass(27,"chemis","Phản ứng hóa học giữa axit và bazơ tạo ra loại chất gì?",Arrays.asList("Muối và nước","Gas","Kết tủa","Nước"),1,1));
        questionList.add(new QuestionClass(28,"chemis","Cặp chất nào sau đây phản ứng tạo kết tủa trắng?",Arrays.asList("C2H4 và dung dịch KMnO4","Phenol và dung dịch Br2","Phenol và dung dịch HNO3 đặc","CH3NH2 và dung dịch FeCl3"),2,1));
        questionList.add(new QuestionClass(29,"chemis","Đồng phân của glucozơ là?",Arrays.asList("mantozơ","saccarozơ","glixerol","fructozơ"),4,1));
        questionList.add(new QuestionClass(30,"chemis","Chất có thể dùng làm mềm nước cứng tạm thời là?",Arrays.asList("NaCl","NaHSO4","Na2CO3","HCl"),3,1));

        questionList.add(new QuestionClass(31,"bio","Cây dương xỉ là đại diện tiêu biểu cho nhóm thực vật nào?",Arrays.asList("Hạt trần","Hạt kín","Quyết","Lớp 3 lá mầm"),3,0));
        questionList.add(new QuestionClass(32,"bio","Yếu tố nào sau đây không cần thiết cho sự quang hợp ở thực vật?",Arrays.asList("Khí hidro","Nước","Khí cacbonic","Ánh sáng"),1,0));
        questionList.add(new QuestionClass(33,"bio","Cá chép có tim mấy ngăn?",Arrays.asList("1","2","3","4"),2,0));
        questionList.add(new QuestionClass(34,"bio","Thủy tức thuộc ngành động vật gì?",Arrays.asList("Thân mềm","Ruột khoang","Giun đốt","Động vật nguyên sinh"),2,0));
        questionList.add(new QuestionClass(35,"bio","Vai trò của ruột già là gì?",Arrays.asList("Hấp thụ chất dinh dưỡng","Hấp thụ nước và thải phân","Tiết HCl 0.3% cho tiêu hóa","Đào thải enzim"),2,0));
        questionList.add(new QuestionClass(36,"bio","Loại tế bào nào tạo ra các tế bào mới thông qua quá trình nguyên phân",Arrays.asList("Tế bào thực vật","Tế bào máu","Tế bào vi khuẩn","Tế bào thực bào"),4,1));
        questionList.add(new QuestionClass(37,"bio","Loài nào thuộc họ động vật có xương sống?",Arrays.asList("Nhện","Côn trùng","Động vật lưỡng cư","Động vật thân mềm"),3,1));
        questionList.add(new QuestionClass(38,"bio","Loại nào của gen di truyền từ cha hoặc mẹ sang con cái?",Arrays.asList("Gen trội","Gen lặn","Gen đẳng vị","Gen đồng hợp tử"),4,1));
        questionList.add(new QuestionClass(39,"bio","Loại cơ bản của cấu trúc gene là gì?",Arrays.asList("RNA","DNA","Protein","Carbohydrate"),2,1));
        questionList.add(new QuestionClass(40,"bio","Quá trình nào giúp duy trì sự đa dạng gen trong một quần thể?",Arrays.asList("Di truyền","Đột biến","Chọn lọc tự nhiên","Thích nghi"),3,1));

        questionList.add(new QuestionClass(41,"his","Năm 938, ai là người lãnh đạo chiến thắng tại Bạch Đằng, chấm dứt sự thống nhất của người Nam và người Bắc?",Arrays.asList("Ngô Quyền","Lê Lợi","Trần Hưng Đạo","Lý Thường Kiệt"),1,0));
        questionList.add(new QuestionClass(42,"his","Ai là vị vua cuối cùng của triều đại nhà Lý?",Arrays.asList("Lý Thái Tổ","Lý Chiêu Hoàng","Lý Huệ Tông","Lý Nhân Tông"),2,0));
        questionList.add(new QuestionClass(43,"his","Chiến thắng Điện Biên Phủ diễn ra vào năm nào?",Arrays.asList("1945","1977","1954","1986"),3,0));
        questionList.add(new QuestionClass(44,"his","Ai là người sáng lập Đảng Cộng sản Việt Nam?",Arrays.asList("Nguyễn Ái Quốc","Võ Nguyên Giáp","Phạm Hùng","Trường Chinh"),1,0));
        questionList.add(new QuestionClass(45,"his","Trong kháng chiến chống Mĩ, nhân dân vùng đồng bằng sông Cửu Long đã huấn luyện loại ong nào thành vũ khí đánh giặc?",Arrays.asList("Ong lưỡi cày","Ong đất","Ong nghệ","Ong vò vẽ"),4,0));
        questionList.add(new QuestionClass(46,"his","Thời kỳ nào được coi là \"Thời kỳ vàng son\" của văn hóa Việt Nam?",Arrays.asList("Đông Sơn","Lý - Trần","Tiền Lê","Trần - Lê"),4,1));
        questionList.add(new QuestionClass(47,"his","Nước ta mang quốc hiệu Đại Việt từ năm nào?",Arrays.asList("1010","1054","939","931"),2,1));
        questionList.add(new QuestionClass(48,"his","\"Cổ kim vi chính luận\", văn bản phê phán quan chức đô hộ đầu tiên của nước ta, được sáng tác bởi ai ?",Arrays.asList("Trưng Trắc","Thi Sách","Trưng Nhị","Lê Chân"),2,1));
        questionList.add(new QuestionClass(49,"his","\"Ngồi yên đợi giặc không bằng trước hãy đem quân ra phá thế mạnh của giặc\", câu nói nổi tiếng này của ai?",Arrays.asList("Trần Quốc Tuấn","Ngô Quyền","Lý Thường Kiệt","Quang Trung"),3,1));
        questionList.add(new QuestionClass(50,"his","Cuộc chiến tranh thế giới thứ nhất diễn ra trong giai đoạn nào?",Arrays.asList("1914 - 1918","1915 - 1918","1916 - 1919","1917 - 1920"),1,1));

        questionList.add(new QuestionClass(51,"geo","Đặc điểm của đất feralit là?",Arrays.asList("Thường có màu đỏ, phèn, chua, nghèo dinh dưỡng","Thường có màu đen, xốp, dễ thoát nước","Thường có màu đỏ vàng, rất màu mỡ","Thường có màu nâu, không thích hợp để trồng lúa"),1,0));
        questionList.add(new QuestionClass(52,"geo","Tài nguyên khoáng sản Việt Nam tập trung nhiều nhất ở?",Arrays.asList("Miền Bắc","Miền Trung","Miền Nam","Biển và hải đảo"),1,0));
        questionList.add(new QuestionClass(53,"geo","Quần đảo Trường Sa trục thuộc tỉnh nào?",Arrays.asList("Quảng Nam","Quảng Ngãi","Bà Rịa - Vũng Tàu","Khánh Hòa"),4,0));
        questionList.add(new QuestionClass(54,"geo","Loại gió có tác động thường xuyên đến lãnh thổ nước ta là?",Arrays.asList("Gió mùa Đông Bắc","Gió Mậu Dịch","Gió phơn","Gió mùa Tây Nam"),2,0));
        questionList.add(new QuestionClass(55,"geo","Đâu là vùng chuyên môn hóa về lương thực thực phẩm lớn nhất nước ta?",Arrays.asList("Đồng bằng Sông Hồng","Tây Nguyên","Đồng bằng Sông Cửu Long","Vùng núi Tây Bắc"),3,0));
        questionList.add(new QuestionClass(56,"geo","Rừng nhiệt đới Amazon đặc trưng cho khu vực nào?",Arrays.asList("Nam Mỹ","Bắc Mỹ","Châu Phi","Nam Cực"),1,1));
        questionList.add(new QuestionClass(57,"geo","Lục địa nào chiếm diện tích lớn nhất trên thế giới?",Arrays.asList("Châu Phi","Châu Âu","Châu Mỹ","Châu Á"),4,1));
        questionList.add(new QuestionClass(58,"geo","Thành phố nào được biết đến là \"Thành phố của những cây cầu\"?",Arrays.asList("Paris","Venice","San Francisco","Prague"),3,1));
        questionList.add(new QuestionClass(59,"geo","Đâu là dòng sông dài nhất thế giới?",Arrays.asList("Sông Amazon","Sông Hằng","Sông Mississippi","Sông Nile"),4,1));
        questionList.add(new QuestionClass(60,"geo","Việt Nam có bao nhiêm km đường bờ biển?",Arrays.asList("2630 km","3260 km","2360 km","3620 km"),2,1));

        questionList.add(new QuestionClass(61,"tech","Đâu là hệ điều hành phổ biến cho máy tính cá nhân?",Arrays.asList("Windows","Mac","MacOS", "Linus"),1,0));
        questionList.add(new QuestionClass(62,"tech","Kích thước lưu trữ thông thường của một ổ đĩa USB tiêu chuẩn là bao nhiêu gigabyte?",Arrays.asList("8 GB","16 GB","32 GB","Tất cả đều đúng"),4,0));
        questionList.add(new QuestionClass(63,"tech","Tên người sáng lập Microsoft là ai?",Arrays.asList("Mark Zuckerberg","Steve Jobs","Bill Gates","Larry Page"),3,0));
        questionList.add(new QuestionClass(64,"tech","Định dạng file hình ảnh phổ biến nhất là gì?",Arrays.asList("BMP","PNG","JPG/JPEG","GIF"),3,0));
        questionList.add(new QuestionClass(65,"tech","\"HTTP\" là viết tắt của gì trong ngữ cảnh của trang web?",Arrays.asList("HyperText Transfer Protocol","High-Tech Transfer Protocol","Hypertext Technical Protocol","High Transfer Technology Protocol"),1,0));
        questionList.add(new QuestionClass(66,"tech","Loại màn hình nào có độ phân giải cao hơn giúp hiển thị hình ảnh và văn bản chi tiết hơn?",Arrays.asList("LCD","LED","OLED","4K"),4,1));
        questionList.add(new QuestionClass(67,"tech","Thuật ngữ \"Phần mềm mã nguồn mở\" có ý nghĩa gì?",Arrays.asList("Phần mềm được phát triển bởi một công ty duy nhất","Mã nguồn mà mọi người có thể xem, sửa đổi, và phân phối miễn phí","Phần mềm có giá trị cao","Phần mềm chỉ dành cho mục đích giáo dục"),2,1));
        questionList.add(new QuestionClass(68,"tech","Tên người sáng lập SpaceX và Tesla là ai?",Arrays.asList("Jeff Bezos","Elon Musk","Mark Zuckerberg","Larry Page"),2,1));
        questionList.add(new QuestionClass(69,"tech","Khái niệm \"Internet of Things\" (IoT) liên quan đến việc gì?",Arrays.asList("Kết nối Internet qua Wi-Fi","Sự kết nối giữa các máy tính cá nhân","Sự kết nối giữa các quốc gia qua Internet"," Kết nối của các thiết bị thông minh"),4,1));
        questionList.add(new QuestionClass(70,"tech","Đâu là loại kết nối mạng không dây phổ biến được sử dụng để kết nối thiết bị di động và máy tính bảng?",Arrays.asList("GPRS","Wi-fi","Bluetooth","NFC"),2,1));

        questionList.add(new QuestionClass(71,"astra","Hệ Mặt Trời của chúng ta có mấy hành tinh?",Arrays.asList("6","7","8","9"),3,0));
        questionList.add(new QuestionClass(72,"astra","Tên của hành tinh đỏ nổi tiếng trong Hệ Mặt Trời là gì?",Arrays.asList("Venus","Mars","Earth","Saturn"),2,0));
        questionList.add(new QuestionClass(73,"astra","Ngôi sao nào là nguồn năng lượng chính cho hệ mặt trời?",Arrays.asList("Alpha Centauri","Sirius","Proximal Centauri","Mặt trời"),4,0));
        questionList.add(new QuestionClass(74,"astra","Chất khí nào chiếm phần lớn trong khí quyển của Trái Đất?",Arrays.asList("Nitơ","Oxy","Argon","Cacbon dioxidde"),1,0));
        questionList.add(new QuestionClass(75,"astra","Hành tinh nào gần Mặt trời nhất?",Arrays.asList("Venus","Earth","Uranus","Jupiter"),1,0));
        questionList.add(new QuestionClass(76,"astra","Loại thiên thạch nào gây ra sự tàn phá lớn nhất trên Trái Đất khoảng 66 triệu năm trước?",Arrays.asList("Quasar","Asteroid","Comet","Meteoroid"),2,1));
        questionList.add(new QuestionClass(77,"astra","Đâu là hành tinh lớn nhất trong Hệ Mặt Trời?",Arrays.asList("Jupiter","Saturn","Mars","Neptune"),1,1));
        questionList.add(new QuestionClass(78,"astra","Neil Armstrong đặt chân lên mặt trăng lần đầu tiên vào năm bao nhiêu?",Arrays.asList("1990","1969","1972","1982"),2,1));
        questionList.add(new QuestionClass(79,"astra","Hiện tượng ngày và đêm xảy ra do đặc điểm gì của Trái Đất?",Arrays.asList("Chiếu sáng từ Mặt Trời","Sự xoay quanh trục","Hành tinh di chuyển quanh Mặt Trời","Sự thay đổi của địa hình Trái Đất"),2,1));
        questionList.add(new QuestionClass(80,"astra","Hố đen là gì?",Arrays.asList("Một loại sao siêu lớn","Một vùng không gian không có vật thể","Một quá trình phát xạ ánh sáng","Một khu vực trong không gian có trọng lực siêu mạnh, đến nổi không thể thoát ra được cả ánh sáng"),4,1));
    }
}
