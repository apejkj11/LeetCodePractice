
//588. Design In-Memory File System
//Trie
class FileSystem {
	public class File{
		String content = "";
		HashMap<String, File> child = new HashMap<>();
		boolean isFile;
	}
	File root;
    public FileSystem() {
		root = new File();
	}
	public List<String> ls(String path) {
		String[] pathlist = path.split("/");
		File cur = root;
		for(int i = 1; i < pathlist.length; i ++){
			cur = cur.child.get(pathlist[i]);
		}
		if(cur.isFile){
			return List.of(pathlist[pathlist.length - 1]);
		}else{
			List<String> tmp = new ArrayList<>(cur.child.keySet());
			Collections.sort(tmp);
			return tmp;
		}
	}
	public void mkdir(String path) {
		String[] pathlist = path.split("/");
		File cur = root;
		for(int i = 1; i < pathlist.length; i ++){
			cur.child.putIfAbsent(pathlist[i], new File());
			cur = cur.child.get(pathlist[i]);
		}
	}
	public void addContentToFile(String filePath, String content) {
		String pathlist = filePath.split("/");
		File cur = root;
		for(int i = 1; i < pathlist.length; i ++){
			cur.child.putIfAbsent(pathlist[i], new File());
			cur = cur.child.get(pathlist[i]);
		}
		cur.isFile = true;
		cur.content = cur.content + content;
	}
	public String readContentFromFile(String filePath) {
		File cur = root;
		String[] pathlist = filePath.split("/");
		for(int i = 1; i < pathlist.length; i ++){
			cur = cur.child.get(pathlist[i]);
		}
		return cur.content;
	}
}