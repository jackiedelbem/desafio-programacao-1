require 'rails_helper'

RSpec.describe PageController, type: :controller do

  describe "GET #index" do

    let(:sales) {[double(Sale)]}
    let(:sum) { 100 }

		before do
			allow(Sale).to receive(:all).and_return(sales)
			allow(Sale).to receive(:totalSales).and_return(sum)
    end
    
    it "returns http success" do
      get :index
      expect(response).to have_http_status(:success)
    end
  end

end
