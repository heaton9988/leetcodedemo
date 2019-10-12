package base;

public class MaxHeap_PriorityQueue {
	private int[] arrData;
	private int size;

	public MaxHeap_PriorityQueue(int initCapacity) {
		arrData = new int[initCapacity + 1];
		arrData[0] = Integer.MAX_VALUE;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == arrData.length - 1;
	}

	public boolean insert(int data) {
		if (isFull()) {
			System.out.println("full, can't insert");
			return false;
		}
		arrData[++size] = data;
		for (int i = size; arrData[i] > arrData[i / 2]; i /= 2) {
			int t = arrData[i];
			arrData[i] = arrData[i / 2];  //父节点下移到子节点的位置
			arrData[i / 2] = t;
		}
		return true;
	}

	//删除一个节点，并返回最大值
	public int deleteMax() {
		//如果为空
		if (isEmpty()) {
			System.out.println("空，无元素可删除");
			return -1;
		}
		//取出最大值
		int maxValue = arrData[1];
		int tmp = arrData[size--];
		//将最后一个节点放在根节点位置,再和左右子树比较
		int parent = 1, child = 2;
		for (; parent * 2 <= size; parent = child) {
			child = parent * 2;  //左孩子
			//判断是否有右孩子，并且右孩子是否比左孩子大
			if (child < size && arrData[child + 1] > arrData[child]) {
				child++;  //child指向左右孩子的较大者
			}
			//如果根节点比左右孩子都要大，则停止比较
			if (tmp > arrData[child]) {
				break;
			} else {
				int t = arrData[parent];
				arrData[parent] = arrData[child];
				arrData[child] = t;
			}
		}
		//把最后一个节点放在parent位置
		arrData[parent] = tmp;
		return maxValue;
	}

	//打印堆元素
	public void print() {
		if (isEmpty()) {
			System.out.println("无元素");
			return;
		}
		for (int i = 1; i <= size; i++) {
			System.out.print(arrData[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] b = { 10, 8, 4, 5, 9, 15, 11, 20 };
		MaxHeap_PriorityQueue heap = new MaxHeap_PriorityQueue(b.length);
		for (int i = 0; i < b.length; i++) {
			heap.insert(b[i]);
		}
		System.out.println("插入后形成最大堆：");
		heap.print();
		//下面测试删除后是否还是最大堆
		for (int i = 0; i < 2; i++) {
			System.out.println("删除元素：" + heap.deleteMax());
		}
		System.out.println("删除后是否还是最大堆：");
		heap.print();
	}
}