
public class SetImplementation 
{
	private int currentIndex = 0;
	private int[] arr;
	public SetImplementation() 
	{
		arr = new int[32];
	}
	
	public boolean isEmpty() {
		return currentIndex==0;
	}

	public boolean add(int element) 
	{
		if(currentIndex<arr.length) 
		{
			boolean x=contains(element);
			if(x)
				return false;
		arr[currentIndex++]=element;
		return true;
		}
		else
		{
			int[] temp = new int[arr.length*2];
			for(int i=0; i<arr.length; i++)
				temp[i] = arr[i];
			arr = temp;
			return add(element);
		}
	}

	public boolean contains(int element) 
	{
		int x=getIndex(element);
		if(x!=-1)
			return true;
		return false;
	}
	
	public Integer size() {
		return currentIndex;
	}

	public Integer getIndex(int element) 
	{
		int i,x=-1;
		for(i=0;i<currentIndex;i++)
		{
			if(arr[i]==element)
			{
				x=i;
			}
		}
		return x;
	}
	
	public boolean remove(int element) {
		int x=getIndex(element);
		if(x!=-1)
		{
				int j=x+1;
				while(j<currentIndex) 
				{
					arr[x++]=arr[j++];
				}
				currentIndex--;
				return true;
			}
		return false;
		}
	}

