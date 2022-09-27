# JsonQuery
converter Json format to Sql 

<h1>Eslatma</h1>
<h3>
Ushbu repositoryga tegishli resurslar(Java kod, json format) <text color="green"><b>Islomda</b></text> joiz bo'lmagan maqsadlarda be'vosita va bilvosita ham ishlarga ishlatilishi mumkin emas!
(Ayniqsa ribo va shunga o'hshash joiz bo'lmagan ishlarda)
</h3>


Library maqsadi Json formatta berilgan ma'lumot asosida 
Sql tilida zapros yasab bazadan ma'lumotlarni olib natijani 
Json massiv shaklda qaytarish
    Bunda Json formattan kelib chiqib library tanlangan DBMS(Oracle, PostgreSql, ...)
ga mos sql select yasaydi! Va bu orqali keyinchalik tizimda DBMS 
o'zgarishi og'riqsiz o'tadi!

Json format asosiy qismlari bu :
1. source - ma'lumotlarni qayerdan olishni ko'rsatadi, bu select ham bo'lishi mumkin.
2. fields - jadval ustunlari
3. filters - jadvaldan ma'lumotlarni tortish shartlari

kutubhona filters qismida operator "exists" bo'lsa bunda "value" maydon 
o'rniga yana "query" beriladi va "query" yana yuqoridagi formatta takrorlanadi
bu sql selectda subquery ishlatish imkonini beradi!

Misol:

    {
        "query": 
        {
            "id": "table_name",
            "source": "table_name",
            "fields": [
                {
                    "column": "id",
                    "format": "number",
                    "type": "number"
                },
                {
                    "column": "account",
                    "format": "number(0-9, 20)",
                    "type": "text"
                },
                {
                    "column": "date_expire",
                    "format": "dd.MM.yyyy",
                    "type": "date"
                },
                {
                    "column": "account_name",
                    "format": "text",
                    "type": "text"
                },
                {
                    "column": "acccode_name",
                    "format": "text",
                    "type": "text"
                }
            ],
            "filters": [
                {
                    "column": "id",
                    "operator": "=",
                    "value": "123"
                },
                {
                    "column": "acc",
                    "operator": "=",
                    "value": "100010860262667011313092001"
                },
                {
                    "column": "date_expire",
                    "operator": "range",
                    "value": ["12.10.2022", "22.10.2022"]
                },
                {
                    "column": "emp",
                    "operator": "=",
                    "value": "TEST"
                },
                {
                    "column": "accname",
                    "operator": "exists",
                    "query": {
                        "id": "smetapoints",
                        "source": "select * from smetapoints s where s.idsmeta = v_smeta_form.id",
                        "fields": [
                            {
                                "column": "expense",
                                "type": "text",
                                "format": "text"
                            }
                        ],
                        "filters": [
                            {
                                "column": "expense",
                                "operator": "=",
                                "value": "14111100"
                            },
                            {
                                "column": "month",
                                "operator": "=",
                                "value": [1,2,3,4,5,6,7]
                            }
                        ]
                    }
                }
            ]
        }
    }


Example

![img.png](img.png)

