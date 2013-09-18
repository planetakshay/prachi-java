package practice;

public class ReadWrapper {

	private byte[] content;

	private static final int BLOCK_SIZE = 4;

	private static byte[] fileSystem = new byte[1000000];

	static {

		for (int i = 0; i < fileSystem.length; i++) {

			fileSystem[i] = 100;
		}
	}

	public static void main(String args[]) {

	}

	public void read(int offset, int size) {

		content = new byte[size];

		byte[] temp;

		int start = offset % BLOCK_SIZE;

		int end = 0;

		int blockToBeRead = size / BLOCK_SIZE;

		for (int i = 0; i < blockToBeRead; i++) {

			temp = readBlock(i);

			copy(start, end, temp);
		}

	}

	public byte[] readBlock(int number) {

		byte[] temp = { fileSystem[0], fileSystem[1] };

		return temp;
	}

	public void copy(int start, int end, byte[] temp) {

	}
}
