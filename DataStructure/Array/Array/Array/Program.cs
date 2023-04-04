int[] arr = new int[] { 1, 2, 3 };
OurArray our = new OurArray();
our.Resize<int>(ref arr, 5);
Console.WriteLine(String.Join(", ", arr));

int item = our.GetAt<int>(arr, 2,sizeof(int));
Console.WriteLine(item);