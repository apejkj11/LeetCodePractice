
//937. Reorder Data in Log Files
class Solution {
    public String[] reorderLogFiles(String[] logs) {
		int n = logs.length;
		
		Arrays.sort(logs, new Comparator<String>(){
			public int compare(String log1, String log2){
				//index 2 means split the string to 2 parts
				String[] a = log1.split(' ', 2);
				String[] b = log2.split(' ', 2);
				//check contents is digit or not
				boolean a1 = Character.isDigit(a[1].charAt(0), b1 = Character.isDigit(b[1].charAt(0));
				//both contents are not digit
				if(!a1 && !b1){
					//check contents
					int tmp = a[1].compareTo(b[1]);
					if(tmp != 0) return tmp;
					//if the same contents check identifier
					return a[0].compareTo(b[0]);
				}
				//log1 is letter, log2 is digit
				if(!a1){
					return -1;
				}
				if(!a2){
					return 1;
				}
				return 0;
			}
		});
		return logs;
	}
}