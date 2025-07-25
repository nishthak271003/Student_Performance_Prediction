

import mysql.connector
import mysql.connector
import pandas as pd

# Step 1: Connect to MySQL
conn = mysql.connector.connect(
    host='localhost',
    user='root',
    password='root',
    database='yourdb'
)

# Step 2: Export all student records
query = "SELECT * FROM students"
df = pd.read_sql(query, conn)

# Step 3: Save to CSV
df.to_csv("students_export.csv", index=False)
print("✅ Export successful!")

conn.close()
