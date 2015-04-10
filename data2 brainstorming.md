#Data2 Brainstorm/planning
##Richard Le

ANSWERED
- Does lecture 15.java work for AVL trees? 
- How does next() work for 1hr 04m - AS_Union????
- How do you write TreeGen's here()? Should it return the key or the current item of the SEQUENCE?? confused
- What does AS_Union do in next()?
- Should FiniteBag extend Comparable???
 - doesn't make sense for a Multiset to be greater than or less than another— by what criteria??

#Prompt:
Your bags should be polymorphic, i.e. use generics to allow any kind of contents. By "pure", we mean that operations on the set return new sets and do not modify the old set.

###Requirements
- Finite bags/multiset
  - each element can occur many times
- Polymorphic (use generics)
- Pure functional implementation
  - return new instances
- Follow properties of finite bags/multisets
- Use iteration abstraction Iterable/sequence/fold...
- Generate test cases
  - test-first programming?

===

#Tasks:
###Legend
[~] in progress
[x] completed
[ ] to do
[ ] 

===


[x] Finish implementing equal() from data1

[x] Rewrite/refactor FiniteSets to FiniteBag, write JavaDoc for functions
[~] Write API (interface) for FiniteBag

##Concrete Implementations

#Implementation PROCESS:
1. Write JavaDoc for functions
2. Write tests for function
3. Write implementations

###Reworking data1
[x] Refactor/rewrite Leaf
[x] Add generics to Leaf
[x] Make generics comparable for Leaf

[x] Rewrite/refactor Tree, write JavaDoc for functions
[x] Rebuild constructor for Tree to accomodate int count
[x] Add generics to Tree
[~] Make generics comparable for Tree
	- issue: Use comparable methods in the generics for implementings an AVL 
	tree...



###Iteration abstraction
[x] Make a Sequence interface  
[x] Make a Sequenced interface 

[x] Make an EmptySequence class

Sequences are like lists BUT they are pay-as-you-go performance instead
[x] Make Tree extend Sequence
[x] Make a Combine class
[x] Combine extends Sequence
[x] Make a Middle class
[x] Middle extends Sequence

##BAG
[x] Add a count field
[u] Make member() work for bag
	[ ] member only returns true if count > 0
[u] Tree remove() for bag
[u] Make removeN work for bags
[u] union for bags
( Same as multiset sum  )
[u] intersect for bags
[u] diff for bags

Tree
[x] add() for bags - 
[x] addN() for bags

Leaf
[x] add() for bags  
[x] addN() for bags

=== 

##AVL TREES
Tree rotation research 
http://en.wikipedia.org/wiki/Tree_rotation


[ ] Add a height field
[ ] Decide when the left or right rotation should occur
[ ] Write the left rotation
[ ] Write the right rotation
[ ] Implement AVL trees for Tree class

Getter methods for left, right, count, key, height
Are these needed for rotations?
[ ] Tree
[ ] Leaf


##Testing
===

###Migration
[ ] Migrate tests from data1 to data2

###Testing tools


###Leaf
Functions of Leaf to test:
[ ] Leaf 
    - don't test constructor
[x] empty
[ ] toString
[x] size
[x] isEmptyHuh
[ ] member
[ ] add
[ ] equals
[ ] remove
[ ] union
[ ] inter
[ ] diff
[ ] subset
[ ] equal
[ ] multiplicity

##Writing implementations
[ ] Comment out unused functions
[ ] Test-first programming— write test first!

===

#Research/planning
[x] Learn what a multiset is
[x] List properties of multisets
[x] Use Java generics examples
[x] Read about JavaDoc syntax for manual

###JavaDoc research
Cheatsheet for JavaDoc:
http://www.liferay.com/community/wiki/-/wiki/Main/Javadoc+Guidelines#section-Javadoc+Guidelines-Constructor:+with+parameters

###Tester Library
http://www.ccs.neu.edu/javalib/Tester/

###CS Bags (specific)
http://algs4.cs.princeton.edu/13stacks/

###Bags (math):
http://en.wikipedia.org/wiki/Multiset

###CS Bags:
http://en.wikipedia.org/wiki/Set_(abstract_data_type)#Multiset

#Planning the API
===
[x] Devise Abstraction strategy- what should be an interface?
  - What operations should be done on the finite bag? 
  - Can items be removed from finite bags? YES


#Submission
===

You should turn in your source code, a console transcript of your test suite’s execution, and an essay which describes your approach to implementing and verifying the system. Your essay should probably make reference to specific lines in your source code and test transcript.

You will be graded on the persuasiveness of your essay.

However, you also need to turn in a manual for your library. The library should document the API, describe its use, explain the properties that hold between API calls, and present performance characteristics. I recommend using a tool like Javadoc to help you make this manual.

You will be graded on the thoroughness of your manual.

These two pieces of the project will be weighted equally.

===

#Submission Checklist

[ ] Source code /src
[ ] Console transcript
[ ] Essay
  - explain approach to implementing and verifying the system
[ ] API/library manual
  - Document the API's functions
  - Describe the uses
  - Explain properties
  - Performance characteristics (linear, log, etc?)





DEPRECATED
Sequence is just a functional version of Iterable. 
Iterators are mutable...

Sequenced (things that are sequenced) - Iterable
Sequence - Iterator is the 

[~] Classes of the FiniteBag need to have generators of their own 
[~] Generator for Tree: TreeGen
[ ] Generator for Leaf: TreeGen
(Refer to 16.java)

