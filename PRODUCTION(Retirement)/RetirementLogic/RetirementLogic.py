def retirement(starting_balance = 0, yearly_deposit = 1000
            , interest = .08, number_of_years = 30):
    years = []       
    
    original_start_balance = starting_balance

    interest_earned = (starting_balance +  yearly_deposit) * interest
    ending_balance = starting_balance +  yearly_deposit + interest_earned

    for no in range(1, number_of_years + 1):        

        year = {"no": no, "startingBalance": starting_balance
                 , "yearlyDeposit": yearly_deposit
                 , "interestEarned": interest_earned, "endingBalance": ending_balance}
        
        years.append(year)
        starting_balance = ending_balance
        interest_earned = (starting_balance +  year["yearlyDeposit"]) * interest
        ending_balance = starting_balance + yearly_deposit + interest_earned

    monthly_deposit = yearly_deposit / 12
    daily20Days = monthly_deposit / 20
    daily30Days = monthly_deposit / 30


    result = {"startingBalance": original_start_balance
            , "yearlyDeposit": yearly_deposit
            , "yield": interest,  "monthlyDeposit": monthly_deposit, "daily20Days" : daily20Days
            , "daily30Days" : daily30Days, "years":years,}

    return result

if __name__ == "__main__":

    _401k = 350_000
    _pension = 797_000
    _stocks = 175_000

    starting_balance = _401k + _pension + _stocks

    results = retirement(starting_balance = 500_000, yearly_deposit = 12_000
                , interest = .08, number_of_years = 10)

    for x in results["years"]:
        print(x)

    print(100 *"-")
    print(results)