package deppar;

public class Word {
	/*
	 * 1	ID	Token counter, starting at 1 for each new sentence.
	   2	FORM	Word form or punctuation symbol.
       3	LEMMA	Lemma or stem (depending on particular data set) of word form, or an underscore if not available.
       4	CPOSTAG	Coarse-grained part-of-speech tag, where tagset depends on the language.
       5	POSTAG	Fine-grained part-of-speech tag, where the tagset depends on the language, or identical to the coarse-grained part-of-speech tag if not available.
       6	FEATS	Unordered set of syntactic and/or morphological features (depending on the particular language), separated by a vertical bar (|), or an underscore if not available.
       7	HEAD	Head of the current token, which is either a value of ID or zero ('0'). Note that depending on the original treebank annotation, there may be multiple tokens with an ID of zero.
       8	DEPREL	Dependency relation to the HEAD. The set of dependency relations depends on the particular language. Note that depending on the original treebank annotation, the dependency relation may be meaningfull or simply 'ROOT'.
       9	PHEAD	Projective head of current token, which is either a value of ID or zero ('0'), or an underscore if not available. Note that depending on the original treebank annotation, there may be multiple tokens an with ID of zero. The dependency structure resulting from the PHEAD column is guaranteed to be projective (but is not available for all languages), whereas the structures resulting from the HEAD column will be non-projective for some sentences of some languages (but is always available).
      10	PDEPREL	Dependency relation to the PHEAD, or an underscore if not available. The set of dependency relations depends on the particular language. Note that depending on the original treebank annotation, the dependency relation may be meaningfull or simply 'ROOT'.
	 * 
	 * */
	
	public int id;
	public String form;
	public String pos;
	public int head;
	
	public String deprel;
	
	
	public int pos_id;
	public long form_id;
	public int deprel_id;
	
	public Word(){
		
	}
	
	// Initialized from conll line
	public Word(String line){
		String[] args = line.trim().split("\t");
		id = Integer.parseInt(args[0]);
		form = args[1];
		pos = args[4].trim();
		head = Integer.parseInt(args[6]);
		deprel = args[7].trim();
	}
	
	public String toConllLine(){
		return "" + id + "\t" + form + "\t_\t" + pos + "\t" + pos + "\t_\t" + head + "\t" + deprel + "\t_\t_";
	}

	public static Word START(){
		Word w = new Word();
		w.form = "</s>";
		w.pos = "</s>";
		w.deprel = "</s>";
		w.head = -1;
		return w;
	}

	public static Word END(){
		Word w = new Word();
		w.form = "</s>";
		w.pos = "</s>";
		w.deprel = "</s>";
		return w;
	}
	
	public void numeralize(Dictionary dic){
		form_id = dic.formToNum(form);
		pos_id = dic.posToNum(pos);
		deprel_id = dic.deprelToNum(deprel);
	}
	
}
