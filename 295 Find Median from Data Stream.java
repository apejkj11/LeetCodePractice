//295. Find Median from Data Stream

class MedianFinder {
	PriorityQueue<Integer> min = new PriorityQueue<>();
	PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> (b - a));
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(max.isEmpty() || num <= max.peek()){
			max.offer(num);
			if(max.size() > min.size() + 1){
				min.offer(max.poll());
			}
		}else{
			min.offer(num);
			if(min.size() > max.size()){
				max.offer(min.poll());
			}
		}
    }
    
    public double findMedian() {
        if((max.size() + min.size()) % 2 == 1){
			return (double)max.peek();
		}else{
			return (double)(max.peek() + min.peek()) / 2;
		}
    }
}