public class Author
{
	private String firstName;
	private String lastName;
	private String middleName;
	private String initials;
	private int noOfPublications;
	private Set<Publication> publicationSet;

	public Author(String fn, String ln, String mn, String ini)
	{
		this.firstName = fn;
		this.lastName = ln;
		this.middleName = mn;
		this.initials = ini;
		this.noOfPublications = 0;
		this.publicationSet = new HashSet<Publication>();
	}

	public Author(String fn, String mn)
	{
		this.firstName = fn;
		this.lastName = ln;
		this.initials = String.valueOf(fn.charAt(0)) + String.valueOf(ln.charAt(0));
	}

	public void setFirstName(String fn){ this.firstName = fn; }
	public void setLastName(String ln){ this.lastName = ln; }
	public void setMiddleName(String mn){this.middleName = mn; }
	public void setInitials(String ini){this.initials = ini; }

	public void addPublication(Publication p)
	{
		this.publicationSet.add(p);
		this.noOfPublications += 1;
	}

	public int matchName(String input)
	{
		int noOfMatches = 0;
		for(String i : input)
		{
			if(i.equals(this.firstName) || i.equals(this.lastName) || i.equals(this.middleName) || i.equals(this.initials))
				noOfMatches += 1;
		}
		return noOfMatches;;
	}
}