import java.util.*;

public class GrayCode {
	
	static List<Integer> grayCode(int n) {
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0); list.add(1);
		ArrayList<Integer> tmp = new ArrayList<>();
		while(++cnt < n) {
			int mid = (int)Math.pow(2, cnt) - 1;
			for(int i = mid ; i >= 0 ; i--) list.add(list.get(i));
			tmp.clear();
			for(int y : list) tmp.add(y);
			list.clear();
			// front
			for(int i = 0 ; i < tmp.size()/2 ; i++) {
				int val = tmp.get(i);
				String str = Integer.toBinaryString(val);
				if(str.length() != cnt) {
					while(str.length() != cnt) str = "0"+str;
				}
				str = "0"+str;
				list.add(Integer.parseInt(str,2));
			}
			// back
			for(int i = tmp.size()/2 ; i < tmp.size() ; i++) {
				int val = tmp.get(i);
				String str = Integer.toBinaryString(val);
				if(str.length() != cnt) {
					while(str.length() != cnt) str = "0"+str;
				}
				str = "1"+str;
				list.add(Integer.parseInt(str,2));
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		int n = 5;
		System.out.println(grayCode(n));
	}
}
