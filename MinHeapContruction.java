import java.util.*;

// Do not edit the class below except for the buildHeap,
// siftDown, siftUp, peek, remove, and insert methods.
// Feel free to add new properties and methods to the class.
class Program {
  static class MinHeap {
    List<Integer> heap = new ArrayList<Integer>();

    public MinHeap(List<Integer> array) {
      heap = buildHeap(array);
    }

    public List<Integer> buildHeap(List<Integer> array) {
      // Write your code here.
			int firstParentIdx = (array.size() - 2)/2;
			for(int currentIdx =firstParentIdx; currentIdx >=0; currentIdx-- ){
				siftDown(currentIdx, array.size()-1, array);
			}
      return array;
    }

    public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
      // Write your code here.
			int childOneIdx = currentIdx*2 +1;
			while(childOneIdx  <= endIdx){
				int childTwoIdx =  currentIdx*2 +2 <= endIdx ? currentIdx*2 +2: -1;
				int idxswap ;
				if(childTwoIdx != -1 && heap.get(childTwoIdx) < heap.get(childOneIdx)){
					 idxswap = childTwoIdx;
				}else{
					idxswap=childOneIdx;
				}
				if ( heap.get(idxswap) <heap.get(currentIdx)){
					swap(currentIdx,idxswap, heap);
					currentIdx = idxswap;
					childOneIdx = currentIdx*2+1;
				}
				else{
					return;
				}
			}
			
    }

    public void siftUp(int currentIdx, List<Integer> heap) {
      // Write your code here.
			int parentIdx = ((currentIdx -1)/2);
			while (currentIdx>0 && heap.get(currentIdx) < heap.get(parentIdx)){
				swap(currentIdx,parentIdx,heap);
				currentIdx = parentIdx;
				parentIdx = (currentIdx -1)/2;
			}
			
    }
		public void swap(int i, int j, List<Integer> heap ){
			Integer temp =  heap.get(i);
			heap.set(i, heap.get(j));
			heap.set(j, temp);	
		}
    public int peek() {
      // Write your code here.
      return heap.get(0);
    }

    public int remove() {
      // Write your code here.
			int res = heap.get(0);
			int lastIndex=heap.size()-1;
			swap(0,lastIndex, heap );
			heap.remove(lastIndex);
			lastIndex=heap.size()-1;
			siftDown(0,lastIndex, heap );
      return res;
    }
    public void insert(int value) {
      // Write your code here.
			heap.add(value);
			siftUp(heap.size()-1, heap);
    }
  }
}
