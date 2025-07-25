##  Student Performance Tracker

A hybrid project built using **Java**, **MySQL**, and **Python** to track student data, analyze academic performance, and predict future scores using machine learning. This project also integrates **Power BI/Excel** for insightful visualizations.

---

## Technologies Used

- **Java (Swing + JDBC)** – Front-end interface to input student data
- **MySQL** – Backend database for storage and queries
- **Python (Jupyter Notebook)** – ML model for mark prediction and data analysis
- **Power BI / Excel** – For dashboards and visual insights


## Project Structure

StudentPerformanceTracker/
├── java-ui/ # Java Swing application (Eclipse)
├── python-model/ # ML notebook (Jupyter)
├── database/ # MySQL .sql dump and CSV export
├── charts/ # Visual outputs (PNG, Excel)
└── README.md


---

## Setup Instructions

### 1️⃣ Java UI (Eclipse)
- Open the `StudentForm.java` file in Eclipse.
- Then open `StudentDatabase` to make the database to connect to the back.
- Add the required JAR files from the `JAR FILES` document.
- Connect to MySQL using JDBC by updating DB credentials.
- Run the UI and fill student form data; data is inserted into MySQL.

### 2️⃣ MySQL Database
- Use `student.sql` to create the required table.
- Sample table includes fields like Name, Roll No, Attendance, Hours_Studied, etc.

### 3️⃣ Python Prediction
- Open `Export_students.py` to export the stored csv file into the jyupter notebook.
- Open `training_model.ipynb` to train the model and performing the tests.
- The trained model is stored in `student_model.pkl` 
- Now, the prediction is performed on the predicted input of the `predict_input.csv` file.
- The output is then automatically stored in `predict_out.csv`.
-The visulization is then performed on the predicted output in the `predict_from_file.iypnb` file  
- Install required libraries (`pandas`, `seaborn`, `scikit-learn`).
- The notebook loads CSV, trains a model, and predicts marks.

### 4️⃣ Visualizations
- Python generates heatmaps and scatter plots.
- Excel/Power BI provides bar charts, dashboards, and trends.
- The outputs are stored in the `Images` folder. 

---

## Key Features

- Add student data using Java UI
- Store and manage records in MySQL
- Predict marks using Linear Regression
- Visualize trends and performance metrics

---

## Future Improvements

- Web deployment using Flask/Django
- Enhanced ML models (Random Forest, XGBoost)
- Real-time dashboard with Power BI Service

---

