/*
 * Copyright 2020 Web3 Labs Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package io.epirus.console.account.subcommands;

import io.epirus.console.EpirusCommand;
import io.epirus.console.EpirusVersionProvider;
import io.epirus.console.project.InteractiveOptions;
import picocli.CommandLine;

import static io.epirus.console.config.ConfigManager.config;

@CommandLine.Command(
        name = "reset",
        description = "Initialise an Epirus account wallet",
        showDefaultValues = true,
        abbreviateSynopsis = true,
        mixinStandardHelpOptions = true,
        versionProvider = EpirusVersionProvider.class,
        synopsisHeading = "%n",
        descriptionHeading = "%nDescription:%n%n",
        optionListHeading = "%nOptions:%n",
        footerHeading = "%n",
        footer = "Epirus CLI is licensed under the Apache License 2.0")
public class ResetCommand implements Runnable {
    @Override
    public void run() {
        if (config.getLoginToken() != null && config.getLoginToken().length() > 0) {
            String walletPath =
                    new InteractiveOptions().createWallet(EpirusCommand.DEFAULT_WALLET_FOLDER);
            config.setDefaultWalletPath(walletPath);
        }
    }
}
