package basic_p;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@MultipartConfig(
	location="D:\\lecture\\program\\java\\program\\tomcat\\apache-tomcat-10.1.18\\temp",
	maxFileSize = 1024*1024*10,
	maxRequestSize = 1024*1024*1000,
	fileSizeThreshold = 1024*1024*10
)
public class MultiRegSvt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultiRegSvt() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 단일 파일 업로드 (파라미터 명 지정)
		// request.getPart("file");  
		
		//다중 파일 업로드 (파라미터 명 지정 불가)
		Collection<Part> parts = request.getParts(); 
		
		String fileName = "";
		String [] arr = {};
		
		for(Part part : parts) {
			System.out.println(part.getName());	//파라미터 명
			if(part.getName().equals("file")){//파일 저장
				
				arr = part.getHeader("content-disposition").split(";");
				
				//배열 잘 들어갔는지 확인
				//System.out.println(Arrays.toString(arr));
				
				for (String array : arr) {
					String arrayName = array.trim().replaceAll("\"", "");
					if(arrayName.startsWith("filename=")) {
						fileName=arrayName.substring(arrayName.indexOf("=")+1);
					}
				}
				//System.out.println("fileName :" + fileName);
				
				String dirName = request.getServletContext().getRealPath("fileFolder");;
				dirName = "C:\\kimhyejung\\study\\javaWork\\jspProj\\src\\main\\webapp\\fileFolder";
				
				//파일 저장
				part.write(dirName+"\\"+fileName);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
