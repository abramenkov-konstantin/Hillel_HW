package HW05;

public class HW05 
{
	// строки
	// 01 вывести в одну строку символы
	// - английского алфавита от 'A' до 'Z'
	// - английского алфавита от 'z' до 'a'
	// - русского алфавита от 'а' до 'я'
	// - цифры от '0'до '9'
	// - печатного диапазона таблицы ASCII

	// 02 написать и протестировать функции преобразования:
	// - целого числа в строку
	// - вещественного числа в строку
	// - строки в целое число
	// - строки в вещественное число

	// 03 написать и протестировать функции работы со строками:
	// - дана строка, состоящая из слов, разделенных пробелами и знаками препинания,
	//   определить длину самого короткого слова
	// - дан массив слов. Заменить последние 3 символа слов, имеющих заданную длину
	//   на символ $
	// - Добавить в строку пробелы после знаков препинания, если они там отсутствуют
	// - Оставить в строке только один экземпляр каждого встречающегося символа
	// - Подсчитать количество слов во введенной пользователем строке
	// - Удалить из строки ее часть с заданной позиции и заданной длины
	// - Перевернуть строку, т.е. последние символы должны стать первыми, а первые последними
	// - В заданной строке удалить последнее слово

	public static void main(String[] args) 
	{
		ascii();
		System.out.println(conversIntToString(20));
		System.out.println(conversDoubleToString(20.233));
		System.out.println(conversStringToInt("1114"));
		System.out.println(conversStringToDouble("1234.34"));
		//String str_in = "Ккк    кжек прекрасен кэтот чудесный,замечательный и?изумительный мир!  ";
		String str_in = "1234567890";

		System.out.println("Исходная строка: " + str_in);
		String words [] = {"Как", "же", "прекрасен", "этот", "Иван", "профан", "диван", "овал"};
		System.out.println("Длина самого короткого слова:" + shortestWordLength (str_in));
		System.out.println("add space: " + addSpace(str_in));
		int posStart =1, len= 8;
		words = changeLastThreeSymbols(words,4);
		for (String name:words)	System.out.print(name + " ");
		System.out.println("По одному символу: " + oneExample(str_in));
		System.out.println("Слов в строке: " + countWords(str_in));
		System.out.println("Удалить " + len + " символ(а/ов), начиная с " + posStart +" символа: " + deletePart(str_in, posStart, len));
		System.out.println("Реверс строки: " + reversStr(str_in));
		System.out.println("Удалить последнее слово: " + delLastWord(str_in));
	}

	public static void ascii()
	{	// строки
		// 01 вывести в одну строку символы
		// - английского алфавита от 'A' до 'Z'
		for (int i=65; i<65+26; i++)
		{
			System.out.print((char)i + " ");
		}
		System.out.println();

		// - английского алфавита от 'z' до 'a'
		for (int i=122; i>122-26; i--)
		{
			System.out.print((char)i + " ");
		}
		System.out.println();

		// - русского алфавита от 'а' до 'я'
		for (int i=1072; i<1072+34; i++)
		{
			System.out.print((char) i + " ");
		}
		System.out.println();

		// - цифры от '0'до '9'
		for (int i=49; i<=57; i++)
		{
			System.out.print((char)i + " ");
		}
		System.out.println();

		// - печатного диапазона таблицы ASCII ???
		for (int i=1; i<=255; i++)
		{
			System.out.print((char)i + " ");
		}
		System.out.println();
	}

	public static String conversIntToString(int x)
	{
		// 02 написать и протестировать функции преобразования:
		// - целого числа в строку
		return Integer.toString(x);
	}

	public static String conversDoubleToString(double x)
	{
		// 02 написать и протестировать функции преобразования:
		// - вещественного числа в строку
		return Double.toString(x);
	}

	public static int conversStringToInt (String str)
	{
		// 02 написать и протестировать функции преобразования:
		// - строки в целое число
		int i = 0;
		try 
		{
			i = Integer.valueOf(str);    
		}
		catch (NumberFormatException e) 
		{  
			System.err.println("Неверный формат строки!");  
		}  
		return i;
	}

	public static double conversStringToDouble(String str)
	{
		// 02 написать и протестировать функции преобразования:
		// - строки в вещественное число
		double d=0;
		try 
		{
			d =  Double.valueOf(str);
		} 
		catch (NumberFormatException e) 
		{
			System.err.println("Неверный формат строки!");
		}
		return d;
	}


	public static int shortestWordLength (String str)
	{
		// - дана строка, состоящая из слов, разделенных пробелами и знаками препинания,
		//   определить длину самого короткого слова
		if (str==null || str=="")
			throw new IllegalArgumentException();

		String[] words = str.split("\\s+|\\, |\\. |\\? |\\! |: |; |\\.|\\,|\\?|\\!");

		int index = 0;
		for (int i=0; i<words.length; i++)
		{
			if (words[i].length()<words[index].length())
				index=i;
		}
		return words[index].length();
	}


	public static String[] changeLastThreeSymbols(String words[], int len)
	{
		// - дан массив слов. Заменить последние 3 символа слов, имеющих заданную длину
		//   на символ $
		if (words==null || words.length==0 || len<3)
			throw new IllegalArgumentException();

		for (int i=0; i<words.length; i++)
		{
			if (words[i].length()==len)
			{
				words[i]=words[i].substring(0, len-3)+"$";
			}
		}
		return words;
	}

	public static String addSpace(String str)
	{
		// - Добавить в строку пробелы после знаков препинания, если они там отсутствуют
		if (str==null || str=="")
			throw new IllegalArgumentException();

		str = str.replace(",", ", ");
		str = str.replace("!", "! ");
		str = str.replace("?", "? ");
		str = str.replace(":", ": ");
		str = str.replace(";", "; ");
		str = str.replace(")", ") ");
		str = str.replace(". . . ", "... ");
		str = str.replaceAll("\\s+", " ");
		str= str.trim();
		return str;
	}

	public static String oneExample(String str)
	{
		// - Оставить в строке только один экземпляр каждого встречающегося символа
		if (str==null || str=="")
			throw new IllegalArgumentException();

		System.out.println("\n");
		for (int i=0; i<str.length(); i++)
		{
			while (str.indexOf(str.charAt(i), i+1)>0)
			{
				str = str.substring(0, str.indexOf(str.charAt(i), i+1)) + str.substring(str.indexOf(str.charAt(i), i+1)+1, str.length());
			}
		}
		return str;
	}

	public static int countWords (String str)
	{
		// - Подсчитать количество слов во введенной пользователем строке
		if (str==null || str=="")
			throw new IllegalArgumentException();

		str = str.trim();
		String[] words = str.split("\\s+|\\, |\\. |\\? |\\! |: |; |\\.|\\,|\\?|\\!");
		return words.length;
	}

	public static String deletePart (String str, int posStart, int len)
	{	
		// - Удалить из строки ее часть с заданной позиции и заданной длины
		if (str==null || str=="" || posStart<0 || len>str.length())
			throw new IllegalArgumentException();

		str = str.substring(0, posStart-1) + str.substring(posStart - 1 + len, str.length());

		return str;
	}

	public static String reversStr (String str)
	{
		// - Перевернуть строку, т.е. последние символы должны стать первыми, а первые последними
		if (str==null || str=="")
			throw new IllegalArgumentException();

		char[] charArray = str.toCharArray();
		char tmp;
		int d=0;

		if (str.length()%2==0) d=0; else d=1;

		for (int i=0; i<(str.length()/2)-1+d; i++)
		{
			tmp = charArray[i];
			charArray[i] = charArray[str.length()-i-1];
			charArray[str.length()-i-1] = tmp;
		}
		return new String(charArray);
	}

	public static String delLastWord (String str)
	{
		// - В заданной строке удалить последнее слово
		if (str==null || str=="")
			throw new IllegalArgumentException();

		return str.trim().replaceAll("\\s\\S*$", "");
	}
}