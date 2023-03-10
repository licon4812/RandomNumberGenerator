using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using Windows.Foundation;
using Windows.Foundation.Collections;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Navigation;

// The Blank Page item template is documented at https://go.microsoft.com/fwlink/?LinkId=402352&clcid=0x409

namespace RandomNumberGenerator
{
    /// <summary>
    /// An empty page that can be used on its own or navigated to within a Frame.
    /// </summary>
    public sealed partial class MainPage : Page
    {
        public MainPage()
        {
            this.InitializeComponent();
            MinInput.Text = "0";
            MaxInput.Text = "100";
        }


        private void Button_Click(object sender, RoutedEventArgs e)
        {
            if (int.TryParse(MinInput.Text, out int min) && int.TryParse(MaxInput.Text, out int max))
            {
                if (min < max)
                {
                    Random random = new Random();
                    int randomNumber = random.Next(min, max + 1);
                    RandomNumber.Text = randomNumber.ToString();
                }
                else
                {
                    RandomNumber.Text = "Min value must be less than max value";
                }
            }
            else
            {
                RandomNumber.Text = "Invalid input";
            }
        }

        private void NavigationView_ItemInvoked(Windows.UI.Xaml.Controls.NavigationView sender, Windows.UI.Xaml.Controls.NavigationViewItemInvokedEventArgs args)
        {
            if (args.IsSettingsInvoked)
            {
                // Do something when Settings is selected
            }
            else
            {
                var item = args.InvokedItemContainer as NavigationViewItem;
                if (item.Content.ToString() == "Decision Maker")
                {
                    // Navigate to the DecisionMaker page
                    this.Frame.Navigate(typeof(DecisionPage));
                }
                else if (item.Content.ToString() == "Number Generator")
                {
                    // Navigate to the NumberGenerator page
                    this.Frame.Navigate(typeof(MainPage));
                }
            }
        }
    }
}
