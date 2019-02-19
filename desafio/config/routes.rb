Rails.application.routes.draw do
  get 'page/index'
  post 'page/import' => 'page#import', via: :post, as: :import_path
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html

  root to:'page#index'
end
