import RetirementLogic as r
from flask import  Flask
from flask import request

app = Flask(__name__)

@app.route("/retirement")
def get_retirement():
    years = request.args.get('years', default= 30, type = int)
    return r.retirement(number_of_years = years)

if __name__ == "__main__":
    app.run(debug=True, port=9814)