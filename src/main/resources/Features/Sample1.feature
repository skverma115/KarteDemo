Feature: Json Object Example

  @AdhocTest
Scenario: Play with json 

* def jsonObject =
"""
[
	{ 
	"name" : "Sumit",
	"City" : "Ranchi",
	"Phone Number" : 78
	},
	{ 
	"name" : "Ram",
	"City" : "Ranchi",
	"Phone Number" : 78
	}
]
""" 

* print jsonObject
* print jsonObject[0]
* print jsonObject[0].name

Scenario: Complex json example

* def jsonObject2 =
"""
[
{
    "glossary": 
    {
        "title": "example glossary",
				"GlossDiv": 
				{
           "title": "S",
				   "GlossList": 
				   {
         			"GlossEntry": 
         				{
                  "ID": "SGML",
									"SortAs": "SGML",
									"GlossTerm": "Standard Generalized Markup Language",
									"Acronym": "SGML",
									"Abbrev": "ISO 8879:1986",
									"GlossDef": 
									{
                        "para": "A meta-markup language, used to create markup languages such as DocBook.",
												"GlossSeeAlso": ["GML", "XML"]
                   },
								  "GlossSee": "markup"
                 }
               }
             }
           }
         }
]
"""

* print jsonObject2[0].glossary.GlossDiv.GlossList.GlossEntry.GlossDef.para