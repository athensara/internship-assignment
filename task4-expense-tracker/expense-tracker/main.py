"""
Expense Tracker Application

Allows users to:
- Add expenses
- View expenses
- Filter expenses by category and date
- Delete expenses
- View sumaries by category

@author: Sneha Timsina
"""

from flask import Flask, render_template, request, url_for, redirect
from flask_sqlalchemy import SQLAlchemy
from datetime import datetime

app = Flask(__name__)

# Setting up configuraton
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///expenses.db'
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
db = SQLAlchemy(app)

# Setting up database
class Expense(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    amount = db.Column(db.Float, nullable=False)
    category = db.Column(db.String(50), nullable=False)
    date = db.Column(db.Date, nullable=False, default=datetime.today)
    note = db.Column(db.String(120))

# Home page route
@app.route('/')
def index():

    # Getting filter values 
    category = request.args.get('category', '')
    date_from = request.args.get('date_from', '')
    date_to = request.args.get('date_to', '')

    # Initialize query
    query = Expense.query

    # Apply filters if added
    if category:
        query = query.filter_by(category=category)

    if date_from:
        query = query.filter(Expense.date >= date_from)

    if date_to:
        query = query.filter(Expense.date <= date_to)

    expenses = query.all()

    # Calculate total spending per category
    summary = {}

    for expense in Expense.query.all():
        summary[expense.category] = (summary.get(expense.category, 0) + expense.amount)

    # Available expense categories
    categories = ['Food','Transport','Rent','Health','Entertainment','Other']

    # Render home page
    return render_template('index.html', expenses=expenses, summary=summary, categories=categories, 
    selected_category=category, date_from=date_from, date_to=date_to)

# Route for adding a new expense
@app.route('/add', methods=['POST'])
def add_expense():

    # Get data from form
    amount = (request.form.get('amount') or "").strip()
    category = (request.form.get('category') or "").strip()
    date = (request.form.get('date') or "").strip()
    note = (request.form.get('note') or "").strip()

    # Convert date string to date object
    date = datetime.strptime(date, "%Y-%m-%d").date()

    # Create and save expense object
    new_expense = Expense(amount=amount, category=category, date=date, note=note)

    db.session.add(new_expense)
    db.session.commit()

    return redirect(url_for('index'))

# check if reading file from right location
if __name__ == '__main__':

    # Create database tables if they do not exist
    with app.app_context():
        db.create_all()

    app.run(debug=True)